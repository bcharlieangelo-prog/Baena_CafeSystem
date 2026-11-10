public class Meal extends MenuItem {
    private static final double UPSIZE_FEE = 20.0;
    private static final double SIDE_FEE = 12.0;

    private boolean upsized;
    private int extraSides;

    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    @Override
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += UPSIZE_FEE;
        }
        return price + (SIDE_FEE * extraSides);
    }

    @Override
    public String getDescription() {
        String size;

        if (upsized) {
            size = "Upsized";
        } else {
            size = "Regular";
        }
        String sides;

        if (extraSides == 1) {
            sides = "1 side";
        } else {
            sides = extraSides + " sides";
        }
        return super.getDescription() + " " + size + ", " + sides;
    }

    public boolean isUpsized() {
        return upsized;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public int getExtraSides() {
        return extraSides;
    }

    public void setExtraSides(int extraSides) {
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}