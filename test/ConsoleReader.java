package test;
/*
Класс ConsoleReader
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReader {
    public static String readString() throws Exception {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int readInt() throws Exception {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static double readDouble() throws Exception {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static boolean readBoolean() throws Exception {
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().equalsIgnoreCase("true")) {
            return true;
        } else if (sc.nextLine().equalsIgnoreCase("false")) {
            return false;
        }
        return false;
        //Либо просто вот так
        //return sc.nextLine().equalsIgnoreCase("true");
    }


    public static void main(String[] args) {

    }
}

