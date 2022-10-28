public class Cafe{
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly ";
        String readyMessage = ", your order is ready ";
        String displayTotalMessage = ", Your total is $";
        


        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double CoffeePrice = 7.5 ;
        double lattePrice = 8.5 ;
        double cappuccinoPrice = 6.0 ;
    


        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1 + pendingMessage ); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(generalGreeting + customer2+ readyMessage+ displayTotalMessage + CoffeePrice);
        System.out.println(generalGreeting + customer3+pendingMessage);
        

        // ** Your customer interaction print statements will go here ** //
        
        // if (isReadyOrder1){
        //     System.out.println(generalGreeting + customer1+ readyMessage+displayTotalMessage);
        //     System.out.println(mochaPrice);
        // }
        // else{
        //     System.out.println(generalGreeting + customer1+ pendingMessage);
        // }

        // if (isReadyOrder3){
        //     System.out.println(generalGreeting + customer3 +" " + readyMessage);
        //     System.out.println(displayTotalMessage + lattePrice);
        // }
        // else{
        //     System.out.println(generalGreeting + customer3+ pendingMessage);
        // }

        //Noah
        if (isReadyOrder4){
            System.out.println( customer4+ readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        }
        else{
            System.out.println( customer4+ pendingMessage);
        }

        //Sam
        System.out.println(displayTotalMessage + (2*lattePrice+CoffeePrice));
        if (isReadyOrder2){
            System.out.println(customer2 + readyMessage );
            System.out.println(displayTotalMessage + (2*lattePrice+CoffeePrice));
        }
        else{
            System.out.println(customer2+ pendingMessage);
        }

        //Jimmy
        System.out.println(customer3 + displayTotalMessage + (lattePrice - CoffeePrice));

    }
}
