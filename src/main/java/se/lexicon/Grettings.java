package se.lexicon;
import java.util.Scanner;

public class Grettings {
    public static String userName;
    public static String devider =  "|===================================================|";
    public static int totalSpace = 48;
    public static int leftSpace;
    public static int rightSpace;

    public static void Gretings() {
        System.out.println( devider);
        System.out.println("|                  LEXICON CAFE                     |");
        System.out.println( devider);
        System.out.println("| Welcome! What is your name?                       |");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.nextLine();
        String message = "Hi " + userName + "! here is the menu:";
        rightSpace = totalSpace - message.length() + 1;
        String dynamicFormat = "| %s %" + rightSpace + "s|\n";
        System.out.println( devider);
        System.out.printf(dynamicFormat, message, "");
        System.out.println( devider);
    }

    public static void thankYou() {
    System.out.println(devider);

        String message = "Thank you, " + userName;

        leftSpace = (int) Math.ceil((48 - message.length()) / 2.0);;
        rightSpace = totalSpace - (leftSpace + message.length());

        String dynamicFormat = "|%" + leftSpace + "s %s %" + rightSpace + "s |\n";


        System.out.println(devider);
        //System.out.printf("|%16.16s Thank you, %s! %17.17s|\n","", userName, "");
        System.out.printf(dynamicFormat,"", message, "");
        if (!Calculation.loyaltyCard) {
            System.out.println("|    register royalty card and get 15% discount!    |");
        }
        System.out.printf("|%18.18s See you again. %17.17s|\n","", "");
        System.out.println(devider);
    }
}
