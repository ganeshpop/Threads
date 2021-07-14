import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;


public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int start =  s.nextInt();
        int end = s.nextInt();
        int total = 0;
        StringBuilder b = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = start; i <= end; i++){
            int input = i;
            while (input > 0) {
                list.add(input % 10);
                input = input / 10;
            }
            for (int number: list) {
                total += Math.pow(number,3);
            }
            if(total == i) {

                b.append(total);
                b.append(" ");
            }
            total = 0;
            list.removeAll(list);
        }
        System.out.println(b);
    }
}
