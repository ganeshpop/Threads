public class LearnThreads extends Thread{
    public static int amount = 0;
        public void run() {
            amount++ ;
            System.out.println("This code is running in a thread");
    }



    public static void main(String[] args) {
        LearnThreads thread = new LearnThreads();
        thread.start();
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }
        System.out.println(amount);
        amount++;
        System.out.println(amount);
        System.out.println("This code is outside of the thread");
    }
}
