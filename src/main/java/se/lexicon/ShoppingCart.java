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
        boolean catalogError = false;

        while (true) {
            System.out.println("|Type the item number and amount!                   |");
            boolean success = false;

            int itemNumber = 0;
            int itemAmount = 0;


            // try catch error handling loop
            while(!success) {
                Scanner item = new Scanner(System.in);
                try {
                    itemNumber = item.nextInt();
                    itemAmount = item.nextInt();
                    success = true;
                } catch ( Exception  e) {
                    System.out.println("❌ Error: try again!\n");
                }
            }
            // ------------------------------

            int catalogIndex = itemNumber - 1;
            boolean repeatedItem = false;
            int repeatIndex = 0;
            //int changeIndex = 0;
            //-------------------------------------

            for (ShoppingCart cartItem : ShoppingCart.basket) {
                if (catalogIndex < 0 || catalogIndex >= Products.CATALOG.length) {continue;}
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

                try {
                    ShoppingCart.addItem(Products.CATALOG[catalogIndex].itemName, Products.CATALOG[catalogIndex].itemPrice, itemAmount);
                } catch (Exception e) {
                   System.out.println("❌ Error: item number out of bound!");
                   //catalogError = true;
                   continue;
                }
            }

            System.out.println(devider);
            System.out.println("|Do you need anything else? type y/n");
            Scanner checkout = new Scanner(System.in);
            String checkoutStr = checkout.next();
            if (checkoutStr.equalsIgnoreCase("n") ) {
                break;
            }
        }

            System.out.println(devider);

    }
}
//next part is calculation and receipt and vat