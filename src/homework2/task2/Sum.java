package homework2.task2;

import java.util.Scanner;

public class Sum
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        long sum = a;
        for(int i=1; i<c; i++) {
            a+=b;
            sum+=a;
        }
        System.out.println(sum);
    }
}
