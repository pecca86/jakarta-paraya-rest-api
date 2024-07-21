package org.eclipse.jakarta.hello.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.eclipse.jakarta.hello.dtos.Color;

// @Converter tells the system the class functions as a JPA converter
@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color color) {
        StringBuilder result = new StringBuilder();
        result.append(color.red())
                .append(",")
                .append(color.green())
                .append(",")
                .append(color.blue());
        return result.toString();
    }

    @Override
    public Color convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        String[] parts = s.split(",");
        return new Color(parts[0], parts[1], parts[2]);
    }
}
