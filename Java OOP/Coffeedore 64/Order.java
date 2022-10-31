import java.util.ArrayList;
class Order{
    private String orderName;
    private boolean readyOrder;
    private ArrayList<Item> items= new ArrayList<Item>();

    public Order(){
        this.orderName = "Guest";
        this.items=new ArrayList<Item>();
    }
    public Order(String orderName){
        this.orderName = orderName ;
        this.items=new ArrayList<Item>();
    }
    // -----------------------   Getters and Setters   ------------------------------------------------//
    public String getOrderName(){
        return (this.orderName) ;
    }
    public void setOrderName(String orderName){
        this.orderName=orderName ;
    }
    // ----------------------------------------------------------------------------------------------//
    public boolean getReadyOrder(){
        return (this.readyOrder) ;
    }
    public void setReadyOrder(boolean readyOrder){
        this.readyOrder= readyOrder;
    }
    // ---------------------------------------------------------------------------------------------//
    public ArrayList<Item> getItems(){
        return (this.items) ;
    }
    public void setItems(ArrayList<Item> items ){
        this.items=items ;
    }

    // ---------------------------------------------------------------------------------------------//

    public void addItem(Item item){
        this.items.add(item);
    }

    //-------------------------------------------------------------------------------------------------//

    public String getStatusMessage(){
        if (this.readyOrder == true){
            return "Your order is ready" ;
        }
        else {
            return "Thank you for waiting. Your order will be ready soon";
        }
    }
    //--------------------------------------------------------------------------------------------------//
    public double getOrderTotal(){
        double tot=0;
        for(Item I : this.items){
            tot += I.getItemPrice();
        }
        return tot;
    }
    //----------------------------------------------------------------------------------------------------//

        public void display(){
        System.out.println("Name : " + this.getOrderName());
        for(Item I : this.items){
            System.out.println( I.getItemName() +" - "+I.getItemPrice());
        }
        System.out.println(this.getOrderTotal());
    }
    
}