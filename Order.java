/**
 * Connects a Customer to up to three MenuItem objects.
 * Items are stored in separate fields (no arrays or collections).
 *
 * @author Your Name
 * @version 1.0
 */
public class Order {
    private static final double STUDENT_DISCOUNT_RATE = 0.10;
    private static final int MAX_ITEMS = 3;
    private static final int LINE_WIDTH = 46;

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;
    private double voucher;
    private boolean pointsAwarded;

    /**
     * Creates an empty order for a customer.
     *
     * @param orderId  the order number
     * @param customer the customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
        this.voucher = 0.0;
        this.pointsAwarded = false;
    }

    /**
     * Adds an item to the first empty slot.
     *
     * @param item the item to add
     * @return true if added, false if the order is already full
     */
    public boolean addItem(MenuItem item) {
        // Fill the first empty slot, or report that the order is full
        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            System.out.println("Order is full. Cannot add " + item.getName()
                    + " [" + item.getItemCode() + "].");
            return false;
        }
        itemCount++;
        return true;
    }

    /**
     * Sums the prices of all items (polymorphic calls to computePrice()).
     *
     * @return the subtotal in pesos
     */
    public double computeSubtotal() {
        double subtotal = 0;
        // Skip empty slots
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Computes the discount amount (10% for students, otherwise 0).
     *
     * @return the discount in pesos
     */
    public double computeDiscount() {
        // Only students get the discount
        if (customer.isStudent()) {
            return computeSubtotal() * STUDENT_DISCOUNT_RATE;
        } else {
            return 0.0;
        }
    }

    /**
     * Computes the total after the student discount.
     *
     * @return the total in pesos
     */
    public double computeTotal() {
        return computeSubtotal() - computeDiscount();
    }

    /**
     * Computes the total after the student discount and a voucher.
     * The total never goes below 0.
     *
     * @param voucher the voucher amount in pesos
     * @return the total in pesos
     */
    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;
        // Never let the total be negative
        if (total < 0) {
            return 0.0;
        } else {
            return total;
        }
    }

    /**
     * Sets a voucher to apply when printing the receipt.
     *
     * @param voucher the voucher amount (negative values are rejected)
     */
    public void setVoucher(double voucher) {
        if (voucher < 0) {
            System.out.println("Error: voucher cannot be negative.");
        } else {
            this.voucher = voucher;
        }
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the number of items in this order.
     *
     * @return the item count
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Prints the receipt and awards loyalty points to the customer
     * (points are awarded only once per order).
     */
    public void printReceipt() {
        String status = "";
        // Mark student customers in the header
        if (customer.isStudent()) {
            status = " (Student)";
        }
        System.out.println("Order #" + orderId + " - " + customer.getName() + status);

        printLine(item1);
        printLine(item2);
        printLine(item3);

        System.out.printf("Subtotal: %.2f%n", computeSubtotal());
        // Show the discount only for students
        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n", computeDiscount());
        }
        // Show the voucher only if one was applied
        if (voucher > 0) {
            System.out.printf("Voucher: -%.2f%n", voucher);
        }
        double total = computeTotal(voucher);
        System.out.printf("TOTAL: %.2f%n", total);

        // Award points once, based on the amount actually paid
        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }

    /**
     * Prints one receipt line with dot padding. Does nothing for an empty slot.
     *
     * @param item the item to print (may be null)
     */
    private void printLine(MenuItem item) {
        if (item != null) {
            String text = item.getDescription() + " ";
            StringBuilder line = new StringBuilder(text);
            while (line.length() < LINE_WIDTH) {
                line.append('.');
            }
            System.out.printf("%s %.2f%n", line, item.computePrice());
        }
    }
}
