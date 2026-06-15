package se.lexicon;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

// add a days customer data and print it at the end of the day

public class Cue {


    private static int userCount = 0;
    private static double total = 0;


    public Cue(int userCount, double total) {

        //userCount = userCount;
        //total = total;
    };



    public static void AddUser(double price) {
        userCount  += 1;
        total += price;
    }

    public static void EndOfDay() {


        String devider = "|===================================================|";

        while (true) {

            Grettings.Gretings();
            CatalogPresentation.CatalogPresentation();
            ShoppingCart.ShoppingProcedure();
            Calculation.Calculation();
            Grettings.thankYou();

            System.out.println("|Next customer please!  y/n                          |");
            Scanner scanner = new Scanner(System.in);
            System.out.println(devider);
            String customer = scanner.nextLine();
            if (customer.equalsIgnoreCase("n")) {
                System.out.println("| No new customer End of the day.                    |");
                System.out.printf("| Custmer served: %d\n", userCount);
                System.out.printf("| Total revenue: %.2f\n", total);
                break;
            }
        }


    }
}
