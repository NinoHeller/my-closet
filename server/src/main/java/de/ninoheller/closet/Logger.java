package de.ninoheller.closet;

public class Logger {

    public static void print(String... str) {
        System.out.println("******************************************************");
        for (String string : str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ((54 - string.length()) / 2); i++) {
                sb.append(" ");
            }
            sb.append(string);

            for (int i = 0; i < ((54 - string.length()) / 2); i++) {
                sb.append(" ");
            }
            System.out.println(sb);
        }
        System.out.println("******************************************************");
    }
}