package me.aisuma.testScanner;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final YamlFile yamlFile = new YamlFile("test.yml");

        try {
            if (!yamlFile.exists()) {
                yamlFile.createNewFile(true);
                System.out.println("new file created");
            } else {
                System.out.println("file already exists");
            }
            yamlFile.load();
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("default values: " + yamlFile.options().copyDefaults());


        yamlFile.addDefault("settings.token", null);
        yamlFile.addDefault("settings.boobs", true);
        yamlFile.addDefault("settings.location", "in paris");

        yamlFile.set("math.pi", Math.PI);

        System.out.println("value of boobs: " + yamlFile.getBoolean("settings.boobs"));
        System.out.println("token? : " + yamlFile.get("settings.token"));
        if (yamlFile.get("settings.token") == null) {
            Scanner input = new Scanner(System.in);
            System.out.println("enter token plz");
            String token = input.nextLine();
            input.close();
            yamlFile.set("settings.token", token);
            System.out.println("set token to: " + token);
        }
        try {
            yamlFile.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        new testMain().testBotJoinWithConfig();
    }

}
