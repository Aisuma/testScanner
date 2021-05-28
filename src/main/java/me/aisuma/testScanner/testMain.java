package me.aisuma.testScanner;

import org.simpleyaml.configuration.file.YamlConfiguration;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;

public class testMain {

    public void testSerialization() {
        YamlFile yamlFile = new YamlFile("test.yml");
        try {
            if (!yamlFile.exists()) {
                System.out.println("Configuration created at: " + yamlFile.getFilePath());
                yamlFile.createNewFile(true);
            } else {
                System.out.println(yamlFile.getFilePath() + " already in existence, loading.");
            }
            yamlFile.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        yamlFile.addDefault("settings", null);
        try {
            yamlFile.save();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
