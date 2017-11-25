package com.flipkart.hbaseobjectmapper;


import com.flipkart.hbaseobjectmapper.exceptions.TooManyHBColumnAnnotationsPresentException;
import com.flipkart.hbaseobjectmapper.exceptions.DuplicateCodecFlagForColumnException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * A wrapper class for {@link HBColumn} and {@link HBColumnMultiVersion} annotations (for internal use only)
 */
class WrappedHBColumn {
    private final String family, column, method;
    private final boolean multiVersioned, singleVersioned, multiId;
    private final Class annotationClass;
    private final Map<String, String> codecFlags;
    private final Field field;

    WrappedHBColumn(Field field) {
        this.field = field;
        HBColumn hbColumn = field.getAnnotation(HBColumn.class);
        HBColumnMultiVersion hbColumnMultiVersion = field.getAnnotation(HBColumnMultiVersion.class);
        HBColumnMultiId hbColumnMultiId = field.getAnnotation(HBColumnMultiId.class);
        checkSingleAnnotationPResent(hbColumn, hbColumnMultiVersion, hbColumnMultiId);
        
        if (hbColumn != null) {
            family = hbColumn.family();
            column = hbColumn.column();
            method = null;
            singleVersioned = true;
            multiVersioned = false;
            multiId = false;
            annotationClass = HBColumn.class;
            codecFlags = toMap(hbColumn.codecFlags());
        } else if (hbColumnMultiVersion != null) {
            family = hbColumnMultiVersion.family();
            column = hbColumnMultiVersion.column();
            method = null;
            singleVersioned = false;
            multiVersioned = true;
            multiId = false;
            annotationClass = HBColumnMultiVersion.class;
            codecFlags = toMap(hbColumnMultiVersion.codecFlags());
        } else if (hbColumnMultiId != null){
        		family = hbColumnMultiId.family();
        		column = null;
        		method = hbColumnMultiId.method();
        		singleVersioned = false;
        		multiVersioned = false;
        		multiId = true;
        		annotationClass = HBColumnMultiId.class;
        		codecFlags = toMap(hbColumnMultiId.codecFlags());
        }
        else {
            family = null;
            column = null;
            method = null;
            singleVersioned = false;
            multiVersioned = false;
            multiId = false;
            annotationClass = null;
            codecFlags = null;
        }
    }

    private void checkSingleAnnotationPResent(HBColumn hbColumn, HBColumnMultiVersion hbColumnMultiVersion,
			HBColumnMultiId hbColumnMultiId) {
		if(hbColumn != null && (hbColumnMultiVersion != null || hbColumnMultiId!= null)) {
			throw new TooManyHBColumnAnnotationsPresentException(field);
		} else if(hbColumnMultiVersion != null && hbColumnMultiId != null) {
			throw new TooManyHBColumnAnnotationsPresentException(field);
		}
	}

	

	private Map<String, String> toMap(Flag[] codecFlags) {
        Map<String, String> flagsMap = new HashMap<>(codecFlags.length, 1.0f);
        for (Flag flag : codecFlags) {
            String previousValue = flagsMap.put(flag.name(), flag.value());
            if (previousValue != null) {
                throw new DuplicateCodecFlagForColumnException(field.getDeclaringClass(), field.getName(), annotationClass, flag.name());
            }
        }
        return flagsMap;
    }

    public String family() {
        return family;
    }

    public String column() {
        return column;
    }
    
    public String method() {
    		return method;
    }

    public Map<String, String> codecFlags() {
        return codecFlags;
    }

    public boolean isPresent() {
        return singleVersioned || multiVersioned || multiId;
    }

    public boolean isMultiVersioned() {
        return multiVersioned;
    }

    public boolean isSingleVersioned() {
        return singleVersioned;
    }
    
    public boolean isMultiId() {
    		return multiId;
    }

    public String getName() {
        return annotationClass.getName();
    }

    @Override
    public String toString() {
        return String.format("%s:%s", family, column);
    }
}
