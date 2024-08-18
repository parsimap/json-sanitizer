package com.google.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    private static final String JSON_HOME = "jsonHome/";

    private static String readJSONFileContent(String fileName){
        try {
            File myObj = new File(JSON_HOME+fileName);
            Scanner myReader = new Scanner(myObj);
            StringBuilder jsonString = new StringBuilder();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                jsonString.append(data);
            }
            myReader.close();return jsonString.toString();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Are you sure the path and the file exist?");
            e.printStackTrace();
            return null;
        }
    }

    private static boolean writeSanitizedJSONFile(String jsonContent, String fileName){
        try {
            FileWriter myWriter = new FileWriter(JSON_HOME+fileName);
            myWriter.write(jsonContent);
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter JSON file name which is in "+JSON_HOME+" directory:");
        String fileName =  scanner.nextLine();
        String jsonString = readJSONFileContent(fileName);
        assert jsonString != null;
        String wellFormedJson = JsonSanitizer.sanitize(jsonString);
        String newFileName = fileName+"_sanitized.json";
        boolean fileWritten =writeSanitizedJSONFile(wellFormedJson, newFileName);
        assert fileWritten;
        System.out.println("Created "+newFileName+" at "+JSON_HOME+".");
    }
}
