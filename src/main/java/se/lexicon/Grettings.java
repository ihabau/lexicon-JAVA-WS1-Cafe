package se.lexicon;
import java.util.Scanner;

public class Grettings {

    public static void Gretings() {
        String menuGreeting = "Here is the menu:";
        String devider =  "|===================================================|";
        System.out.println( devider);
        System.out.println("|                  LEXICON CAFE                     |");
        System.out.println( devider);
        System.out.println("| Welcome! What is your name?                       |");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int nameLength = name.length();
        int spacing = 47;
        spacing -= nameLength;
        String dynamicFormat = "|Hi %s %-" + spacing + "s|\n";
        System.out.println( devider);
        System.out.printf(dynamicFormat, name, menuGreeting);
        System.out.println( devider);
    }
}
