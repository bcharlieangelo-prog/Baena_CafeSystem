public class Pastry extends MenuItem {
    private static final double WARMING_FEE = 10.0;

    private boolean warmed;

    public Pastry() {
        super();
        this.warmed = false;
    }

    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    @Override
    public double computePrice() {
        double price = basePrice;

        if (warmed) {
            price += WARMING_FEE;
        }
        return price;
    }

    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}