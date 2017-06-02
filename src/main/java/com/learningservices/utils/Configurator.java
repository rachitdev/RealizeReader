package com.learningservices.utils;

import java.util.Properties;

import com.learningservices.utils.Log;

public class Configurator {

    private static boolean CONFIG_LOADED = false;

    /** Load test suite settings. */
    private static void loadTestSuiteSettings() {
        try {
            Properties properties = new Properties();
            properties.load(Configurator.class.getClassLoader().getResourceAsStream("config.properties"));
            for (String prop : properties.stringPropertyNames()) {
                System.setProperty(prop, properties.getProperty(prop).toLowerCase().replace("\"", ""));
            }
            Log.message("config.properties file has been loaded successfully!");
        } catch (Exception e) {
            Log.fail("config.properties file is not loaded properly!");
            e.printStackTrace();
        }
    }

    /** Load environment settings. */
    private static void loadEnvironmentSettings() {
        try {
            Properties properties = new Properties();
            // Load environment properties file
            properties.load(Configurator.class.getClassLoader().getResourceAsStream(
                    "config/" + System.getProperty("test_environment") + ".properties"));
            for (String prop : properties.stringPropertyNames()) {
                System.setProperty(prop, properties.getProperty(prop).replace("\"", ""));
            }
            // Set data file path
            String filePath = Configurator.class
                    .getClassLoader()
                    .getResource("datafiles/test_data_" + System.getProperty("test_environment").toLowerCase() + ".xls")
                    .getPath();
            if (filePath.contains("jenkins")) {
                System.setProperty("DATA_SHEET",
                        "build/resources/main/datafiles/test_data_" + System.getProperty("test_environment")
                                .toLowerCase() + ".xls");
            } else {
                System.setProperty("DATA_SHEET",
                        "src/main/resources/datafiles/test_data_" + System.getProperty("test_environment")
                                .toLowerCase() + ".xls");
            }

            Log.message("config/" + System.getProperty("test_environment") + ".properties has been loaded successfully!");
        } catch (Exception e) {
            Log.fail("config/" + System.getProperty("test_environment") + ".properties is not loaded properly!");
            e.printStackTrace();
        }
    }

    /** Load common settings. */
    private static void loadCommonSettings() {
        try {
            Properties properties = new Properties();
            // Load api-urls
            properties.load(Configurator.class.getClassLoader().getResourceAsStream("config/api-urls.properties"));
            for (String prop : properties.stringPropertyNames()) {
                System.setProperty(prop, properties.getProperty(prop).replace("\"", ""));
            }
            // Set SQL Queries file path
            // System.setProperty("QUERIES",
            // Configurator.class.getClassLoader().getResource("sql_queries.xls").getPath());
            if (Configurator.class.getClassLoader().getResource("sql_queries.xls").getPath().contains("jenkins")) {
                System.setProperty("QUERIES", "build/resources/main/sql_queries.xls");
            } else {
                System.setProperty("QUERIES", "src/main/resources/sql_queries.xls");
            }
            Log.message("config/api-urls.properties has been loaded successfully!");
        } catch (Exception e) {
            Log.fail("config/api-urls.properties is not loaded properly!");
            e.printStackTrace();
        }
    }

    /** Load properties.
     *
     * @throws Exception the exception */
    public static void loadProperties() {
        if (!CONFIG_LOADED) {
            loadTestSuiteSettings();
            loadCommonSettings();
            loadEnvironmentSettings();
            CONFIG_LOADED = true;
        }
    }
}
