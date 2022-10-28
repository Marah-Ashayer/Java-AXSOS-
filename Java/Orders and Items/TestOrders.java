import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // ----------------- Item Variables --  item1 , item2, item3, item4 --------------------------// 
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        // --------------------Price -- Name for each item ---------------------------------------- //
        item1.itemName="Mocha";
        item1.itemPrice =3.5 ;

        item2.itemName="Latte";
        item2.itemPrice =6.0 ;

        item3.itemName="drip Coffee";
        item3.itemPrice =12.5 ;

        item4.itemName="capuccino";
        item4.itemPrice =9.0 ;

        // ----------------Order variables -- order1, order2 ,order3 , order4 ------------------------//
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        // -------------------- Name for each Order ---------------------------------------- //
        order1.orderName="Cindhuri";
        order2.orderName="Jimmy";
        order3.orderName ="Noah";
        order4.orderName = "Sam" ;
        //-------------------------------------------------------------------------------------//

        System.out.printf("Name: %s\n", order1);

        order2.items.add(item2);
        order2.orderTotal= order2.orderTotal+item1.itemPrice ;
        // System.out.printf("Total2: %s\n", order2.orderTotal);

        order3.items.add(item4);
        order3.orderTotal= order3.orderTotal+item4.itemPrice ;

        order4.items.add(item2);
        order4.orderTotal= order4.orderTotal+item2.itemPrice;

        order1.readyOrder= true ;

        order4.items.add(item2);
        order4.items.add(item2);
        order4.orderTotal= order4.orderTotal + (2* item2.itemPrice);
        // System.out.printf("Total-4: %s\n", order4.orderTotal);

        order2.readyOrder= true ;

        // ------------------Use this example code to test various orders' updates -----------------//

        // --------------------Order-1 ------------------------------------------//
        System.out.printf("Name-1: %s\n", order1.orderName);
        System.out.printf("Total-1: %s\n", order1.orderTotal);
        System.out.printf("Ready-1: %s\n", order1.readyOrder);
        
        // --------------------Order-2 ------------------------------------------//
        System.out.printf("Name-2: %s\n", order2.orderName);
        System.out.printf("Total-2: %s\n", order2.orderTotal);
        System.out.printf("Ready-2: %s\n", order2.readyOrder);

        // --------------------Order-3 ------------------------------------------//
        System.out.printf("Name-3: %s\n", order3.orderName);
        System.out.printf("Total-3: %s\n", order3.orderTotal);
        System.out.printf("Ready-3: %s\n", order3.readyOrder);

        // --------------------Order-4 ------------------------------------------//
        System.out.printf("Name-4: %s\n", order4.orderName);
        System.out.printf("Total-4: %s\n", order4.orderTotal);
        System.out.printf("Ready-4: %s\n", order4.readyOrder);
    }
}
