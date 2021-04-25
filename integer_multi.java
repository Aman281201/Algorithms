package first_prog;
import java.util.Scanner;
import java.lang.Math;

public class integer_multi {

    public static int karatsuba( int n1,  int n2){
        int n = 1;
        int m =1;
        if(n1!= 0)
        n = (int)Math.log10(n1) + 1;

        if(n2 != 0)
        m = (int)Math.log10(n2) + 1;

        if(n == 1 && m == 1)
        {
            return n1*n2;
        }
        else {
            int a = (int) (n1 / Math.pow(10, n / 2));
            int b = (int) (n1 % Math.pow(10, n / 2));

            int c = (int) (n2 / Math.pow(10, m / 2));
            int d = (int) (n2 % Math.pow(10, m / 2));

            int f = karatsuba(a,c);
            int s = karatsuba(b,d);
            int t = karatsuba(a+b, c+d) - s - f;
            return (int) (Math.pow(10,(n+m)/2)*f + Math.pow(10,n/2)*t + s);

        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int j = karatsuba(n1, n2);
        System.out.println("the product is " + j);


    }
}
