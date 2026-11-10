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

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
        this.voucher = 0.0;
        this.pointsAwarded = false;
    }

    public boolean addItem(MenuItem item) {
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

    public double computeSubtotal() {
        double subtotal = 0;

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

    public double computeDiscount() {
        if (customer.isStudent()) {
            return computeSubtotal() * STUDENT_DISCOUNT_RATE;
        } else {
            return 0.0;
        }
    }

    public double computeTotal() {
        return computeSubtotal() - computeDiscount();
    }

    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;

        if (total < 0) {
            return 0.0;
        } else {
            return total;
        }
    }

    public void setVoucher(double voucher) {
        if (voucher < 0) {
            System.out.println("Error: voucher cannot be negative.");
        } else {
            this.voucher = voucher;
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void printReceipt() {
        String status = "";

        if (customer.isStudent()) {
            status = " (Student)";
        }
        System.out.println("Order #" + orderId + " - " + customer.getName() + status);

        printLine(item1);
        printLine(item2);
        printLine(item3);

        System.out.printf("Subtotal: %.2f%n", computeSubtotal());

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n", computeDiscount());
        }

        if (voucher > 0) {
            System.out.printf("Voucher: -%.2f%n", voucher);
        }
        double total = computeTotal(voucher);
        System.out.printf("TOTAL: %.2f%n", total);

        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }

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