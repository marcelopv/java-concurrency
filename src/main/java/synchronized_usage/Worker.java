package synchronized_usage;

public class Worker implements Runnable {

    private final BankAccount account;

    public Worker(BankAccount bankAccount) {
        this.account = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (account) {
                int startBalance = account.getBalance();
                System.out.println("Start Balance: "+startBalance);
                account.deposit(10);
                int endBalance = account.getBalance();
                System.out.println("End Balance: "+endBalance);
                System.out.println("------------------");
            }
        }
    }

}
