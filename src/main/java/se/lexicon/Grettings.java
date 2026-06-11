package se.lexicon;
import java.util.Scanner;

public class Grettings {
    public static String userName;
    public static String devider =  "|===================================================|";

    public static void Gretings() {
        String menuGreeting = "Here is the menu:";
        System.out.println( devider);
        System.out.println("|                  LEXICON CAFE                     |");
        System.out.println( devider);
        System.out.println("| Welcome! What is your name?                       |");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.nextLine();
        int nameLength = userName.length();
        int spacing = 44;
        spacing -= nameLength;
        String dynamicFormat = "|Hi %s %-" + spacing + "s|\n";
        System.out.println( devider);
        System.out.printf(dynamicFormat, userName, menuGreeting);
        System.out.println( devider);
    }

    public static void thankYou() {
    System.out.println(devider);

        int nameLength = userName.length();
        int spacing =  (int) Math.ceil((47 - nameLength) / 2);
        System.out.println(spacing);
        String dynamicFormat = "|%" + spacing +"s Thank you, %-10s %"+ spacing + "s|\n";


        System.out.println(devider);
        //System.out.printf("|%16.16s Thank you, %s! %17.17s|\n","", userName, "");
        System.out.printf(dynamicFormat,"", userName, "");
        System.out.printf("|%18.18s See you again. %17.17s|\n","", "");
        System.out.println(devider);
    }
}
