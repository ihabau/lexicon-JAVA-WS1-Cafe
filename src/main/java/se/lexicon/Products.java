package se.lexicon;

public class Products {
    public String itemName;
    public double itemPrice;

    public Products(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;

    }

    public static final Products[] CATALOG = {
            new Products("Brew Coffee", 25.00),
            new Products("Espresso", 22.00),
            new Products("Caffe Latte", 38.00),
            new Products("Cappuccino", 38.00),
            new Products("Americano", 28.00),
            new Products("Flat White", 40.00),
            new Products("Macchiato", 32.00),
            new Products("Mocha", 42.00),
            new Products("Cortado", 34.00),
            new Products("Iced Latte", 42.00),

            // === TEA & COLD DRINKS ===
            new Products("Chai Latte", 39.00),
            new Products("Green Tea", 28.00),
            new Products("Earl Grey Tea", 28.00),
            new Products("Hot Chocolate", 35.00),
            new Products("Iced Tea Lemon", 32.00),
            new Products("Fresh Orange Juice", 35.00),
            new Products("Apple Juice", 24.00),
            new Products("Still Water", 20.00),
            new Products("Sparkling Water", 22.00),
            new Products("Coca Cola", 25.00),

            // === PASTRIES & SANDWICHES ===
            new Products("Cinnamon Bun", 28.00),
            new Products("Croissant", 24.00),
            new Products("Chocolate Muffin", 32.00),
            new Products("Blueberry Scone", 26.00),
            new Products("Carrot Cake", 45.00),
            new Products("Cheese Sandwich", 49.00),
            new Products("Avocado Toast", 65.00),
            new Products("Sourdough Bagel", 35.00),
            new Products("Chicken Wrap", 69.00),
            new Products("Vegan Cookie", 20.00)
    };
}
