class Item{ 
    private String itemName;
    private double itemPrice;

    public Item(String itemName, double itemPrice){
        this.itemName=itemName ;
        this.itemPrice=itemPrice ;
    }

    // -----------------------   Getters and Setters   ---------------------------------------------//

    public String getItemName(){
        return this.itemName ;
    }
    public void setItemName(String itemName){
        this.itemName=itemName ;
    }

    public double getItemPrice(){
        return this.itemPrice ;
    }
    public void setItemPrice(double itemPrice){
        this.itemPrice=itemPrice ;
    }
}