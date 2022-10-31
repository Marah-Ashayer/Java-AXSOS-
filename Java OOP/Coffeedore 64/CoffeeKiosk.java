import java.util.ArrayList;
public class CoffeeKiosk{
    public ArrayList<Item> menu;
    public ArrayList<Order> orders;

    public CoffeeKiosk(){
            this.menu= new ArrayList<Item>() ;
            this.orders= new ArrayList<Order>() ;
    }

    public void addMenuItem(String itemName, double itemPrice){
        Item newItem = new Item(itemName , itemPrice );
        menu.add(newItem);
        int index =menu.indexOf(newItem);
        newItem.setIndex(index);
    }
    public void displayMenu(){
        for(Item I : menu){
            System.out.println( I.getIndex() + "  "+ I.getItemName() +" - "+I.getItemPrice());
        }
    }
    public void newOrder() {
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        //---------------------------------------------------------------------------------------//
        // Create a new order with the given input string
        Order newOrder = new Order (name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            for (Item item : menu) {
                if ((Integer.parseInt(itemNumber)) == item.getIndex()) {   
                    newOrder.addItem(item);
                }        
            }
        System.out.println("Please enter a menu item index or q to quit:");
        itemNumber = System.console().readLine();
        }
        orders.add(newOrder);
        newOrder.display();
    }
}



