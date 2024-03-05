package com.example.utils.load_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CredentialList {

    // This class was created to handle credentialList and registeredCredential files in order for test#2 & #3 to run correctly

    private static ArrayList<String> emails = new ArrayList<String>();
    private static ArrayList<String> passwords = new ArrayList<String>();

    private static ArrayList<String> registeredEmails = new ArrayList<String>();
    private static ArrayList<String> registeredPasswords = new ArrayList<String>();

    public static void readCredentialList(){

        try{
            File credentialList = new File("C:\\Users\\juandavid.camacho\\Documents\\Curso_TAE\\Mobile\\MobileAutomationProject-JuanDavidCamachoG\\src\\test\\resources\\credentialList.txt");
            Scanner reader = new Scanner(credentialList);

            while (reader.hasNextLine()){

                String[] line = reader.nextLine().split(",");
                emails.add(line[0]);
                passwords.add(line[1]);

            }

        } catch (FileNotFoundException e){

            System.out.println("Error reading the credentials file");

        }

    }

    public static void readRegisteredCredentials(){

        try{
            File registeredCredentialList = new File("C:\\Users\\juandavid.camacho\\Documents\\Curso_TAE\\Mobile\\MobileAutomationProject-JuanDavidCamachoG\\src\\test\\resources\\registeredCredentials.txt");
            Scanner reader = new Scanner(registeredCredentialList);

            while (reader.hasNextLine()){

                String[] line = reader.nextLine().split(",");
                registeredEmails.add(line[0]);
                registeredPasswords.add(line[1]);

            }

        } catch (FileNotFoundException e){

            System.out.println("Error reading the credentials file");

        }

    }

    // this method returns a random array of credentials to register from the credentialList that has 100 of them
    public static String[] getRandomCredentials(){
        double randomNumber = Math.random()*(100-1);
        int randomId = (int)randomNumber;

        String[] AvailableEmail = {emails.get(randomId), passwords.get(randomId)};
        writeRegisteredCredentials(emails.get(randomId), passwords.get(randomId));
        emails.remove(randomId);
        passwords.remove(randomId);
        return AvailableEmail;
    }

    // this methods writes on registeredCredentials, the set of credentials that were already registered
    public static void writeRegisteredCredentials(String email, String password){

        try{
            FileWriter writer = new FileWriter("C:\\Users\\juandavid.camacho\\Documents\\Curso_TAE\\Mobile\\MobileAutomationProject-JuanDavidCamachoG\\src\\test\\resources\\registeredCredentials.txt", true);
            String stringToWrite = "\n"+email+","+password;
            writer.write(stringToWrite);
            writer.close();
        } catch (IOException e){
            System.out.println("There was an error writing in registeredCredentials.txt");
        }

    }


    // this method returns a random array of credentials already registered, which are stored on registeredCredentials
    public static String[] getRegisteredCredentials(){

        double randomNumber = Math.random()*(registeredEmails.size()-1);
        int randomId = (int)randomNumber;

        return new String[]{registeredEmails.get(randomId), registeredPasswords.get(randomId)};

    }

}
