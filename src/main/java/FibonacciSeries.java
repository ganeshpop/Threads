import java.util.*;
public class FibonacciSeries
{
    int sum=0;
    static int n,a=0,b=1,c=1;
    List<Double> ls=new ArrayList<Double>();
    public void fiboSeries()
    {
        synchronized(this)
        {
            for(int i=0;i<=n;i++)
            {
                c=a+b;
                System.out.println(sum+" + "+b+" = "+(sum+b));
                sum+=b;
                a=b;
                b=c;
                ls.add((double) c);

            }
        }
    }
    public void sumSeries()
    {
        synchronized(this)
        {
            System.out.println("Fibonacci sum series : ");
            for (Double l : ls) {
                System.out.println(l);
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        n=sc.nextInt();
        FibonacciSeries fiboSeries = new FibonacciSeries();
        Thread t1=new Thread(fiboSeries::sumSeries);
        Thread t2=new Thread(fiboSeries::fiboSeries);
        t2.start();
        t1.start();
    }
}