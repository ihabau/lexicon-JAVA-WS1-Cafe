package se.lexicon;

public class CatalogPresentation {

    public static void CatalogPresentation() {
        String devider =  "|===================================================|";
        int counter = 1;
        // spacing problems
        for (Products item : Products.CATALOG) {
            int spacing = 38 - String.valueOf(counter).length();
            String dynamicFormat = "| %s. %-" + spacing + "s %s SEK |\n"; // having - in %-10s means align left
            System.out.printf(dynamicFormat, counter, item.itemName, item.itemPrice );
            System.out.println(devider);
            counter += 1;
        }
    }
}
