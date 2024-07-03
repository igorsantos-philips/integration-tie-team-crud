package com.philips.integrations;

import org.apache.camel.main.Main;

/**
 * DO NOT CHANGE
 * 
 * Starts all the integrations on the project, all the java and yaml files and 
 * include on the classpath all the files on the resources folder.
 * 
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Main main = new Main(Application.class);
        main.run(args);
    }

}
