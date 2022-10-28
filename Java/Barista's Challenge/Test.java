import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
    
        // ----------------- Item Variables --  item1 , item2, item3, item4 --------------------------// 
        Item item1 = new Item("Mocha", 3.5);
        Item item2 = new Item("Latte", 6.0);
        Item item3 = new Item("drip Coffee" , 12.5);
        Item item4 = new Item("capuccino",9.0);


        // item1.setItemPrice(8.0);
        // System.out.println(item1.getItemPrice());



        // Create 2 orders for unspecified guests (without specifying a name) -------------------------
        Order order1 = new Order(); 
        Order order2 = new Order();

        // System.out.println(order1.getOrderName());
        // order1.setOrderName("Marah");
        // System.out.println(order1.getOrderName());

        // Create 3 orders using the overloaded constructor to give each a name for the order ------------------
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Sam");

        //-------------------------------------------------------------------------------------//


        // -------------------------------Tests ----------------------------------------------//

        // --------------------Order-1 ------------------------------------------//
        order1.addItem(item2);
        order1.addItem(item4);
        order1.setReadyOrder( true);
        System.out.println("Name-1:"+ order1.getStatusMessage());
        System.out.println("Name-1:"+ order1.getOrderTotal());
        order1.display();



        System.out.println("Name-3:"+ order2.isReadyOrder());
        
        System.out.println("Name-3:"+ order2.getItems());
        

        System.out.println("Name-1:"+ order1.getItems());

        
        // --------------------Order-2 ------------------------------------------//
        order2.addItem(item1);
        order2.addItem(item3);


        // --------------------Order-3 ------------------------------------------//
        order3.addItem(item1);
        order3.addItem(item4);

        // --------------------Order-4 ------------------------------------------//
        order4.addItem(item2);
        order4.addItem(item1);


        // --------------------Order-5 ------------------------------------------//
        order5.addItem(item2);
        order5.addItem(item4);
        order5.addItem(item3);
        order5.display();
        order5.setReadyOrder(true);
        System.out.println(order5.isReadyOrder());
        System.out.println(order5.getStatusMessage());

        order5.setReadyOrder(false);
        System.out.println(order5.getStatusMessage());
    }
}
// import java.lang.Math;
// public class Test {
//     public static void main(String[] args){
//     int n = 10;
//     int length = (int)(Math.log10(n)+1);
//     System.out.println(length);
// }
// }