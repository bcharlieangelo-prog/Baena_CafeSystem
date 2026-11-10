public class CafeApp {
    public static void main(String[] args) {
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");
        Customer guest = new Customer();
        System.out.println("(Default customer name: " + guest.getName() + ")");
        System.out.println();

        Beverage icedLatte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        Meal chickenAdobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);

        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setItemCode("P-02");
        cookie.setBasePrice(35);

        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setItemCode("M-02");
        beefTapa.setBasePrice(130);

        Order order1 = new Order("1001", ana);
        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);
        order1.addItem(cookie);
        order1.printReceipt();

        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);

        Order order2 = new Order("1002", ben);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.setVoucher(20);
        order2.printReceipt();
    }
}