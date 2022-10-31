public class Account{
    public double checkingBalance;
    public double savingsBalance;
    public static int numberOfAccounts = 0;
    public static double totalAmount ;

    //--------------------------Constructor Method -------------------------------------------//

    public Account(double checkingBalance, double savingsBalance ){
        this.checkingBalance= checkingBalance;
        this.savingsBalance = savingsBalance;
        this.totalAmount=checkingBalance + savingsBalance ;
        numberOfAccounts++;
    }

    // -----------------------Static Methods -----------------------------------------------//

    public static int memberCount(){
        return numberOfAccounts;
    }

    public static double totalAccount(){
        return totalAmount;
    }
    // -------------------------Getters ------------------------------------------------// 

    public double getCheckingBalance(){
        return (this.checkingBalance) ;
    }

    public double getSavingsBalance(){
        return (this.savingsBalance) ;
    }

    //--------------------------------------  Deposite  -----------------------------------------------//

    public void depositMoney(String type ,double deposit){
        System.out.println("Type : "+ type + "  Deposit : $ "+ deposit);
        if(type=="checking"){
            this.checkingBalance+=deposit;
            System.out.println("added $"+ deposit +"  to Checking Balance" );
            System.out.println("Your Checking Balance : $ "+this.checkingBalance );
            System.out.println("Total :  $  " + (totalAmount+=deposit));
        }
        else if (type=="savings"){
            this.savingsBalance+=deposit;
            System.out.println("added $"+ deposit +"  to Savings Balance" );
            System.out.println("Your Savings Balance : $ "+this.savingsBalance );
            System.out.println("Total :  $  " + (totalAmount+=deposit));
        }
        else{
            System.out.println("Something Wrong");
        }
    }

    // ----------------------------------------------------   WithDraw  ----------------------------------//
    
    public void withdrawMoney(String accType ,double amount){
        System.out.println("Account Type : "+ accType + "  Amount : $ "+ amount);
        if(accType=="checking"){
            if(amount < this.checkingBalance){
                this.checkingBalance-=amount;
                System.out.println("Withdraw $"+ amount +"  from Checking Balance" );
                System.out.println("Your Checking Balance : $ "+ this.checkingBalance );
                System.out.println("Total :  $  " + (totalAmount-=amount));
            }
            else{
                System.out.println("No Enough Balance in Your Checking Account ");
            }
        }
        else if (accType=="savings"){
            if(amount < this.savingsBalance){
                this.savingsBalance-=amount;
                System.out.println("Withdraw $"+ amount +"  from Savings Balance" );
                System.out.println("Your Savings Balance : $ "+ this.savingsBalance );
                System.out.println("Total :  $  " + (totalAmount-=amount));
            }
            else{
                System.out.println("No Enough Balance in Your Savings Account ");
            }
        }
        else{
            System.out.println("Something Wrong");
        }
    }

    public void display(){
        System.out.println(this.getCheckingBalance());
        System.out.println(this.getSavingsBalance());
    }
}
