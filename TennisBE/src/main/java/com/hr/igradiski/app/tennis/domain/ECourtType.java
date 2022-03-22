package com.hr.igradiski.app.tennis.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum ECourtType {
    CLAY(1),
    HARD(2),
    GRASS(3),
    ARTIFICIAL_GRASS(4);


    private Integer value;

    ECourtType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static ECourtType fromValue(Integer value) {
        for (ECourtType enumeration : ECourtType.values()) {
            if (enumeration.getValue().equals(value)) {
                return enumeration;
            }
        }
        return null;
    }

    @Converter(autoApply = true)
    @SuppressWarnings("unused")
    public static class CourtConverter implements AttributeConverter<ECourtType, Integer> {

        @Override
        public Integer convertToDatabaseColumn(ECourtType enumeration) {
            return enumeration != null ? enumeration.getValue() : null;
        }

        @Override
        public ECourtType convertToEntityAttribute(Integer value) {
            return ECourtType.fromValue(value);
        }
    }
}
