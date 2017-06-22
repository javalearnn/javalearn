/*
Класс ConsoleReader
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        return read.readLine();
    }

    public static int readInt() throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(read.readLine());

    }

    public static double readDouble() throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(read.readLine());

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine();
        return s.equalsIgnoreCase("true");
    }


    public static void main(String[] args) {

    }
}
