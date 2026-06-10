package se.lexicon;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public String itemName;
    public double unitPrice;
    public int amount;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public ShoppingCart(String itemName, double unitPrice, int amount) {

        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.amount = amount;

    };

    public static final ArrayList<ShoppingCart> basket = new ArrayList<>();

    public static void addItem(String name, double price, int qty) {
        ShoppingCart newItem = new ShoppingCart(name, price, qty);
        basket.add(newItem); // Adds directly to the global list above
        System.out.println("✅ Added to internal class basket: " + name);
    }

    public static void ShoppingProcedure() {

        //------------------------------------
        String devider = "|===================================================|";


        while (true) {
            System.out.println("|Type the item number and amount!                   |");
            Scanner item = new Scanner(System.in);
            int itemNumber = item.nextInt();
            int itemAmount = item.nextInt();
            int catalogIndex = itemNumber - 1;
            boolean repeatedItem = false;
            int repeatIndex = 0;
            //int changeIndex = 0;
            //-------------------------------------
            for (ShoppingCart cartItem : ShoppingCart.basket) {
                if (Products.CATALOG[catalogIndex].itemName.equalsIgnoreCase(cartItem.itemName)) {
                   repeatedItem = true;
                   //changeIndex = repeatIndex;
                   break;
                } else {
                    repeatedItem = false;
                }
                repeatIndex += 1;
            }

            if (repeatedItem == true) {
                System.out.println("reapeat");
                System.out.println("new item added to basket");
                ShoppingCart.basket.get(repeatIndex).amount += itemAmount;
            } else if (repeatedItem == false) {
                System.out.println("new item added to basket");
                ShoppingCart.addItem(Products.CATALOG[catalogIndex].itemName, Products.CATALOG[catalogIndex].itemPrice, itemAmount);
            }

            System.out.println(devider);
            System.out.println("|Do you need anything else? type yes/no");
            Scanner checkout = new Scanner(System.in);
            String checkoutStr = checkout.next();
            if (checkoutStr.equalsIgnoreCase("no") ) {
                break;
            }
        }
        System.out.println(ShoppingCart.basket.size());
        for (ShoppingCart item : ShoppingCart.basket) {
            System.out.printf("|%sDEBUG:  %s | %s | %s |\n", ANSI_RED, item.itemName, item.amount, item.unitPrice);
        }
    }
}
//next part is calculation and receipt and vat