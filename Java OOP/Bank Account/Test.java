public class Test {
    public static void main(String[] args) {

        Account account1 = new Account(4000.0, 950.90);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(account1.totalAccount());
        account1.depositMoney("checking" ,400);
        // account1.depositMoney("fffff" ,200);
        account1.withdrawMoney("fffff" ,200);
        account1.withdrawMoney("savings" ,1000);
        account1.display();



        // System.out.println(Account.memberCount());

        // Account account2 = new Account(1000.0 , 400.55);
        // System.out.println(account2.getCheckingBalance());
        // System.out.println(account2.getSavingsBalance());
        // System.out.println(account2.totalAccount());

        // System.out.println(Account.memberCount());


        // Account account3 = new Account(700.5 , 100.5);
        // System.out.println(account3.getCheckingBalance());
        // System.out.println(account3.getSavingsBalance());
        // System.out.println(account3.totalAccount());

        // System.out.println(Account.memberCount());



    }
}