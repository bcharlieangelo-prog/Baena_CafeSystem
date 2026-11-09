/**
 * Represents a drink sold at the campus cafe.
 * The price depends on the selected size.
 *
 * @author Your Name
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private String size;

    /**
     * Default constructor. Creates a small unnamed beverage.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Parameterized constructor.
     *
     * @param name      the drink name
     * @param basePrice the base price (small size) in pesos
     * @param itemCode  the item code
     * @param size      the size: "S", "M", or "L"
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S"; // safe default in case the given size is invalid
        setSize(size);
    }

    /**
     * Computes the final price based on size.
     *
     * @return the price of this beverage in pesos
     */
    @Override
    public double computePrice() {
        // Large adds 25, Medium adds 15, Small uses the base price
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Describes this beverage including its size.
     *
     * @return the parent description plus the size
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the size.
     *
     * @return "S", "M", or "L"
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size. Only S, M, or L are accepted; otherwise the old value is kept.
     *
     * @param size the new size
     */
    public void setSize(String size) {
        // Accept only valid sizes, keep the old value otherwise
        if (size != null && (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Error: size must be S, M, or L. Keeping " + this.size + ".");
        }
    }
}
