/**
 * Represents a baked item that can be warmed for an extra fee.
 *
 * @author Your Name
 * @version 1.0
 */
public class Pastry extends MenuItem {
    private static final double WARMING_FEE = 10.0;

    private boolean warmed;

    /**
     * Default constructor. Creates an unwarmed unnamed pastry.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Parameterized constructor.
     *
     * @param name      the pastry name
     * @param basePrice the base price in pesos
     * @param itemCode  the item code
     * @param warmed    true if the pastry is to be warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the final price, adding a fee if warmed.
     *
     * @return the price of this pastry in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Warming costs extra
        if (warmed) {
            price += WARMING_FEE;
        }
        return price;
    }

    /**
     * Describes this pastry, noting if it is warmed.
     *
     * @return the parent description plus "(Warmed)" when applicable
     */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    /**
     * Checks whether the pastry is warmed.
     *
     * @return true if warmed
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets whether the pastry is warmed.
     *
     * @param warmed true to warm the pastry
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
