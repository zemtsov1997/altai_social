package ru.altai.service.api.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

@Converter
public class UuidAttributeConverter implements AttributeConverter<UUID, String> {

    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        if (uuid == null) {
            return null;
        } else {
            return uuid.toString();
        }
    }

    @Override
    public UUID convertToEntityAttribute(String uuid) {
        if (uuid == null) {
            return null;
        } else {
            return UUID.fromString(uuid);
        }
    }

}
