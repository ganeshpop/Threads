import java.util.concurrent.*;

public class FibThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        FibCall call = new FibCall();
        Future<String> Future = service.submit(call);
        try {
            System.out.println("Fib series " + Future.get());
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        Future.cancel(true);
        try {
            if (Future.isCancelled()) {
                String result = Future.get();
                System.out.println(result);
            }
            System.out.println("Fib series Ended");
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        service.shutdown();
    }
}

class FibCall implements Callable<String> {

    @Override
    public String call() {
        int var1 = 0;
        int var2 = 1;
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int total = var1 + var2;
            response.append(var1);
            response.append("_");
            var1 = var2;
            var2 = total;
        }
        return response.toString();
    }
}