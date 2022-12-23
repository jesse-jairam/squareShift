package com.project.utils;

import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class SettingsBase {

    protected static Logger log = Logger.getLogger(SettingsBase.class.getName());
    private static String LOCALPATHFORPROPERTIES = File.separator + "src" + File.separator
            + "test" + File.separator + "resources" + File.separator;


    /**
     * Loads the property file and returns an instance of Property Class
     * @param folder
     * @param fileName
     * @return
     */
    protected static Properties loadProperties(String folder, String fileName) {
        Properties props = new Properties();
        try {
            File file = new File(buildPath(folder, fileName));
            FileInputStream fileInput = new FileInputStream(file);
            props.load(fileInput);
            fileInput.close();
            //loaded = true;
            log.debug("Properties file load succeeded. " +
                    props.size() + " property values loaded." +fileName);
        } catch (FileNotFoundException e) {
            log.debug("Properties file load failed."+fileName);
        } catch (IOException e) {
            log.debug("Some other error occurred when loading properties file.");
        }
        return props;
    }

    private static String buildPath(String folder, String propertiesFile) {
        return System.getProperty("user.dir") + LOCALPATHFORPROPERTIES + folder
                + File.separator + propertiesFile;
    }
}
