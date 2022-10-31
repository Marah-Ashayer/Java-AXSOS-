public class Item{ 
    public int index;
    public String itemName;
    public double itemPrice;

    public Item(String itemName, double itemPrice){
        this.itemName=itemName ;
        this.itemPrice=itemPrice ;
    }
    // --------------------------------------Getter and Setter for index ------------------------------//
    public int getIndex(){
        return this.index ;
    }
    public void setIndex(int index){
        this.index=index ;
    }
    // --------------------------------------Getter and Setter for Item Name ------------------------------//
    public String getItemName(){
        return this.itemName ;
    }
    public void setItemName(String itemName){
        this.itemName=itemName ;
    }
    // --------------------------------------Getter and Setter for Price ------------------------------//
    public double getItemPrice(){
        return this.itemPrice ;
    }
    public void setItemPrice(double itemPrice){
        this.itemPrice=itemPrice ;
    }
}