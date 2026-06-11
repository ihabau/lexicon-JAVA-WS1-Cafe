package se.lexicon;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Calculation {
    public String cardNr;


    public static void Calculation() {

        boolean loyaltyCard = false;
        double totalPrice = 0;
        String devider = "|===================================================|";
        String devider2 = "|---------------------------------------------------|";
        System.out.println("| Do you have a loyality card? input y/n            |");
        System.out.println(devider);
        Scanner loyaltyState = new Scanner(System.in);
        String loyaltyStateStr = loyaltyState.next().toLowerCase();

        if (loyaltyStateStr.equalsIgnoreCase("y")) { loyaltyCard = true; };

        System.out.println(devider);
        System.out.printf("|%-16.16s|%-6.6s | %s | %5s |\n", "Item name","amount","unit price","total price");
        System.out.println(devider);

        for (ShoppingCart item : ShoppingCart.basket) {
            double unitTotalPrice = item.amount * item.unitPrice;
            totalPrice += unitTotalPrice;
            System.out.printf("|%-16.16s: x %-6.6s%-4.4s  %15s SEK|\n", item.itemName, item.amount, item.unitPrice, unitTotalPrice);
        }
        System.out.println(devider);
        if (loyaltyCard) {
            Calculation.RandomGen();
            double discount = totalPrice * -0.15;
            totalPrice += discount;
            System.out.printf("|Loyalty discount 15%%: %24.2fs SEK|\n", discount);
        }
        if (!loyaltyCard) {
            System.out.println("|No loyalty card presented 0% discount.             |");
        }
        double vat = totalPrice * 0.12;
        totalPrice += vat;
        System.out.printf("|VAT 12%% %39.2f SEK|\n", vat);
        System.out.println(devider2);
        System.out.printf("|TOTAL %41.2f SEK|\n", totalPrice);
        System.out.println(devider);

        // calculations
        // vat 12% (112% of price)
        // members discount 15% (75% of price)
        // item total price eg ice cream 2x12 kr is 24sek in total
        // total final price

    }

    public static void RandomGen() {

        StringBuilder cardNumber = new StringBuilder(10);

        for (int i = 0; i < 6; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(0, 10);
            cardNumber.append(randomNumber);
        }
        cardNumber.append("-XXXX");
        String strCardNumber = cardNumber.toString();
        System.out.printf("|Loyalty Card number: %-30s|\n",strCardNumber);

    }

}
