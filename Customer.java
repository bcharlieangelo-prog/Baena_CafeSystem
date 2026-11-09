/**
 * Represents the person placing an order. Students get a discount and
 * every customer earns loyalty points.
 *
 * @author Your Name
 * @version 1.0
 */
public class Customer {
    private static final double PESOS_PER_POINT = 50.0;

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor. Creates a non-student "Guest" with no points.
     */
    public Customer() {
        this("Guest", false);
    }

    /**
     * Creates a non-student customer.
     *
     * @param name the customer name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with a student status.
     *
     * @param name    the customer name
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly.
     *
     * @param points the points to add (negative values are rejected)
     */
    public void addPoints(int points) {
        // Points can only go up through this method
        if (points < 0) {
            System.out.println("Error: cannot add negative points.");
        } else {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds loyalty points based on money spent: 1 point per 50 pesos.
     *
     * @param amountSpent the amount spent in pesos
     */
    public void addPoints(double amountSpent) {
        // Only positive spending earns points
        if (amountSpent > 0) {
            loyaltyPoints += (int) (amountSpent / PESOS_PER_POINT);
        }
    }

    /**
     * Gets the customer name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer name. Empty or null names are rejected.
     *
     * @param name the new name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    /**
     * Checks whether the customer is a student.
     *
     * @return true if a student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets the student status.
     *
     * @param student true if a student
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the loyalty points.
     *
     * @return the loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the loyalty points. Negative values are rejected.
     *
     * @param loyaltyPoints the new points total
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Points may never be negative
        if (loyaltyPoints < 0) {
            System.out.println("Error: loyalty points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}
