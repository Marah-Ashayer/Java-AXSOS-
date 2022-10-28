import java.util.ArrayList;
class CafeUtil{


/* ================================================================================================= */

    public int getStreakGoal(){
        int sum=0;
        for(int i=1;i<=10;i++){
            sum=sum+i;
        }
        return sum;
    }
    /* ================================================================================================ */

    public double getOrderTotal(double[] prices){
        double total=0;
        for( int j=0 ; j < prices.length ; j++){
            total=total + prices[j];
        }
        return total;
    }

    /* ==================================================================================================== */

    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i +"  " + menuItems.get(i));
            }
    }

    /* =================================================================================================== */

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine(); 
        System.out.println("Hello ,"+ userName );
        System.out.println("There are  "+ (customers.size()) +"  people in front of you");
        customers.add(userName);
    }

}