public class Test{
    public static void main(String[] args) {
        CoffeeKiosk c1=new CoffeeKiosk();

        c1.addMenuItem("Nescafe",7.0);
        c1.addMenuItem("Coffee",4.5);
        c1.addMenuItem("Cake" ,15.5);

        c1.displayMenu();
        c1.newOrder();

    }
    
}