package se.lexicon;
import java.util.Scanner;

// add a days customer data and print it at the end of the day

public class Cue {
    public static void Cue() {
        while (true) {

            Grettings.Gretings();
            CatalogPresentation.CatalogPresentation();
            ShoppingCart.ShoppingProcedure();
            Calculation.Calculation();
            Grettings.thankYou();

         System.out.println("|Next customer please!  y/n            |");
         Scanner scanner = new Scanner(System.in);
         String customer = scanner.nextLine();
         if (customer.equalsIgnoreCase("n")) {
             System.out.println("| No new customer End of the day.              |");
             break;
         }
        }

    }
}
