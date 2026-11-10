public class Customer {
    private static final double PESOS_PER_POINT = 50.0;

    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        this("Guest", false);
    }

    public Customer(String name) {
        this(name, false);
    }

    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    public void addPoints(int points) {
        if (points < 0) {
            System.out.println("Error: cannot add negative points.");
        } else {
            loyaltyPoints += points;
        }
    }

    public void addPoints(double amountSpent) {
        if (amountSpent > 0) {
            loyaltyPoints += (int) (amountSpent / PESOS_PER_POINT);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0) {
            System.out.println("Error: loyalty points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}