/**
 * Abstract parent of every item sold at the campus cafe.
 * It cannot be instantiated directly; each subclass defines its own pricing.
 *
 * @author Your Name
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor. Creates an unnamed item with no price.
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     *
     * @param name      the item name
     * @param basePrice the base price in pesos
     * @param itemCode  the unique item code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        // Go through the setter so invalid prices are rejected
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the final price of this item. Each subclass defines its own rule.
     *
     * @return the final price in pesos
     */
    public abstract double computePrice();

    /**
     * Returns a short description of this item.
     *
     * @return the name followed by the item code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the item name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item name. Empty or null names are rejected.
     *
     * @param name the new name
     */
    public void setName(String name) {
        // Only accept a usable name
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    /**
     * Gets the base price.
     *
     * @return the base price in pesos
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price. Negative values are rejected.
     *
     * @param basePrice the new base price
     */
    public void setBasePrice(double basePrice) {
        // Reject negative prices, otherwise store the value
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /**
     * Gets the item code.
     *
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code. Empty or null codes are rejected.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        // Only accept a usable code
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Error: item code cannot be empty.");
        }
    }
}
