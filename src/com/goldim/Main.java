package com.goldim;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String str;
        String[] carr;
        String command = null;
        String fileName;
        String text = null;
        do {
            str = in.nextLine();
            carr = str.split(" ");
            command = carr[0];
            if (!command.equals("quit")) {
                fileName = carr[1].replaceAll("\"", "");
                text = null;
                if (!command.equals("read")) {
                    text = carr[2].replaceAll("\"", "");
                }

                switch (command) {
                    case "read":
                        readFromFile(fileName);
                        break;
                    case "write":
                        writeToFile(fileName, text, false);
                        break;
                    case "append":
                        writeToFile(fileName, text, true);
                        break;
                }
            }
        } while (!command.equals("quit"));
        in.close();

    }

    public static void readFromFile (String name) {
        try (
                FileReader fileReader = new FileReader(name);
                BufferedReader br = new BufferedReader(fileReader)
                ){
            System.out.println(br.readLine());

        }catch (IOException e) {

        }finally {

        }
    }

     public static void writeToFile(String name, String text, boolean append){
        try (FileWriter fileWriter = new FileWriter(name , append);
             BufferedWriter bw = new BufferedWriter(fileWriter)){
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
        }
    }
}