package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author wfristdr
 * Simple property util providing the properties 
 * of the config.properties file.
 *
 */
public class PropertyUtil {

	/**
	 * 
	 * @param propKey, the property key
	 * @return the property value
	 */
    public static String getProperty(String propKey) {
        Properties prop = new Properties();
        InputStream input = null;
        String filename = "config.properties";
        String propertyValue = null;

        try {
            input = PropertyUtil.class.getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }
            prop.load(input);
            propertyValue = prop.getProperty(propKey);
            //System.out.println("property value is: " + propertyValue);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;
    }
}
