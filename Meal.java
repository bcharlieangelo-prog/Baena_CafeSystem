/**
 * Represents a rice meal that can be upsized and given extra sides.
 *
 * @author Your Name
 * @version 1.0
 */
public class Meal extends MenuItem {
    private static final double UPSIZE_FEE = 20.0;
    private static final double SIDE_FEE = 12.0;

    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor. Creates a regular meal with no extra sides.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Parameterized constructor.
     *
     * @param name       the meal name
     * @param basePrice  the base price in pesos
     * @param itemCode   the item code
     * @param upsized    true if the meal is upsized
     * @param extraSides the number of extra sides (negative values become 0)
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /**
     * Computes the final price: base + upsize fee + extra side fees.
     *
     * @return the price of this meal in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing costs extra
        if (upsized) {
            price += UPSIZE_FEE;
        }
        return price + (SIDE_FEE * extraSides);
    }

    /**
     * Describes this meal with its upsize status and extra sides.
     *
     * @return the parent description, upsize status, and number of sides
     */
    @Override
    public String getDescription() {
        String size;
        // Pick the label for upsize status
        if (upsized) {
            size = "Upsized";
        } else {
            size = "Regular";
        }
        String sides;
        // Singular vs. plural
        if (extraSides == 1) {
            sides = "1 side";
        } else {
            sides = extraSides + " sides";
        }
        return super.getDescription() + " " + size + ", " + sides;
    }

    /**
     * Checks whether the meal is upsized.
     *
     * @return true if upsized
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets whether the meal is upsized.
     *
     * @param upsized true to upsize
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides. Negative values are rejected.
     *
     * @param extraSides the new number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // Reject negative counts
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
