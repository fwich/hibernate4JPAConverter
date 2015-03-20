package org.jboss.as.quickstart.hibernate4.model;

import javax.persistence.AttributeConverter;
import java.awt.*;

/**
 * Created by florianwich on 20.03.15.
 */
public class ColorConverter implements AttributeConverter<Color, String>
{
  private static final String SEPERATOR = ";";
  @Override
  public String convertToDatabaseColumn(Color attribute)
  {
    StringBuilder color = new StringBuilder();
    color.append(attribute.getRed()).append(SEPERATOR).append(attribute.getGreen()).append(SEPERATOR).append(attribute.getBlue()).append(SEPERATOR).append(attribute.getAlpha());
    return color.toString();
  }

  @Override
  public Color convertToEntityAttribute(String dbData)
  {
    String[] rgb = dbData.split(SEPERATOR);
    int red = Integer.parseInt(rgb[0]);
    int green = Integet.parseInt(rgb[1]);
    int blue = Integer.parseInt(rgb[2]);
    int alpha = Integer.parseInt(rgb[3]);


    return new Color(red, green, blue, alpha);
  }
}
