import java.util.Scanner;

public class FibonacciSeriesDemo extends Thread {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Series Length: ");
        Fib f=new Fib(s.nextInt());
        f.start();
    }


}
class Fibo implements Runnable{
    public int n=0,sum=0,first=0,second=1;
    public Fibo(int number) {
        this.n = number;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.print(first+"+"+second);
        sum=first+second;
        System.out.print("+"+sum);
        for(int i=3;i<n;i++) {

            first=second;
            second=sum;
            sum=first+second;
            System.out.print("+"+sum);
        }
        first=second;
        second=sum;
        sum=first+second;
        System.out.print("="+sum);


    }

}
class Fib extends Thread{
    public int n=0,sum=0,first=0,second=1,first1=0,second1=1,sum1=0;
    //int arr[];
    int arr[]=new int[10];
    public Fib(int n) {
        this.n=n;
    }
    public void run() {
        System.out.print(first+"+"+second);
        sum=first+second;
        arr[0]=sum;
        System.out.print("+"+sum);
        for(int i=3;i<n;i++) {

            first=second;
            second=sum;
            sum=first+second;
            System.out.print("+"+sum);
            arr[i-2]=sum;
        }
        first=second;
        second=sum;
        sum=first+second;
        System.out.println("="+sum);
        System.out.print(first1+"+"+second1);
        sum1=first1+second1;
        System.out.println("="+sum1);
        for(int i=3;i<=n;i++) {
            //System.out.println(first);
            first1=sum1;
            second1=arr[i-3];
            System.out.print(first1+"+"+second1);
            sum1=first1+second1;
            System.out.println("="+sum1);

        }


    }
}

