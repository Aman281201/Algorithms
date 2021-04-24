package first_prog;

import java.math.BigInteger;
import java.util.Scanner;


public class strassen_algo {

    public static int[][] add_sub_ar(int[][] m1, int[][] m2, int n, char s)
    {
        int[][] ans = new int[n][n];
        if(s == '-')
        {
            for(int i = 0; i< n; i++)
                for(int j = 0; j< n; j++)
                    ans[i][j] = m1[i][j] - m2[i][j];
        }

        else if (s == '+')
        {
            for(int i = 0; i< n; i++)
                for(int j = 0; j< n; j++)
                    ans[i][j] = m1[i][j] + m2[i][j];
        }
        else
            System.out.println("wrong arg");

        return ans;

    }

    public static int[][] strassen(int[][] m1, int[][] m2, int n)
    {
        int[][] a = new int[n/2][n/2];
        int[][] b = new int[n/2][n/2];
        int[][] c = new int[n/2][n/2];
        int[][] d = new int[n/2][n/2];
        int[][] e = new int[n/2][n/2];
        int[][] f = new int[n/2][n/2];
        int[][] g = new int[n/2][n/2];
        int[][] h = new int[n/2][n/2];

        int[][] fin = new int[n][n];

        // initializing a,b,c,d,e,f,g,h

        for(int i = 0;i < n; i++)
        for(int j = 0;j < n;j++)
        {
            if(i<n/2 && j < n/2)
                a[i][j] = m1[i][j];

            else if(i<n/2 && j>= n/2)
                b[i][j-n/2] = m1[i][j];

            else if(i>=n/2 && j<n/2)
                c[i-n/2][j] = m1[i][j];
            else
                d[i-n/2][j-n/2] = m1[i][j];
        }

        for(int i = 0;i < n; i++)
            for(int j = 0;j < n;j++)
            {
                if(i<n/2 && j < n/2)
                    e[i][j] = m2[i][j];

                else if(i<n/2 && j>= n/2)
                    f[i][j-n/2] = m2[i][j];

                else if(i>=n/2 && j<n/2)
                    g[i-n/2][j] = m2[i][j];
                else
                    h[i-n/2][j-n/2] = m2[i][j];
            }
        if(n/2 > 1) {
            // computing the 7 products recursively

            int[][] p1 = new int[n / 2][n / 2];
            int[][] p2 = new int[n / 2][n / 2];
            int[][] p3 = new int[n / 2][n / 2];
            int[][] p4 = new int[n / 2][n / 2];
            int[][] p5 = new int[n / 2][n / 2];
            int[][] p6 = new int[n / 2][n / 2];
            int[][] p7 = new int[n / 2][n / 2];

            p1 = strassen(a, add_sub_ar(f, h, n / 2, '-'), n / 2);
            p2 = strassen(add_sub_ar(a, b, n / 2, '+'), h, n / 2);
            p3 = strassen(add_sub_ar(c, d, n / 2, '+'), e, n / 2);
            p4 = strassen(d, add_sub_ar(g, e, n / 2, '-'), n / 2);
            p5 = strassen(add_sub_ar(a, d, n / 2, '+'), add_sub_ar(e, h, n / 2, '+'), n / 2);
            p6 = strassen(add_sub_ar(b, d, n / 2, '-'), add_sub_ar(g, h, n / 2, '+'), n / 2);
            p7 = strassen(add_sub_ar(a, c, n / 2, '-'), add_sub_ar(e, f, n / 2, '+'), n / 2);

            int[][] q1 = new int[n/2][n/2];
            int[][] q2 = new int[n/2][n/2];
            int[][] q3 = new int[n/2][n/2];
            int[][] q4 = new int[n/2][n/2];

            q1 = add_sub_ar(add_sub_ar(p4,p2,n/2,'-'),add_sub_ar(p5,p6,n/2,'+'),n/2,'+');
            q2 = add_sub_ar(p1,p2,n/2,'+');
            q3 = add_sub_ar(p3,p4,n/2,'+');
            q4 = add_sub_ar(add_sub_ar(p1,p7,n/2,'-'),add_sub_ar(p5,p3,n/2,'-'),n/2,'+');

            for(int i = 0;i < n; i++)
                for(int j = 0;j < n;j++)
                {
                    if(i<n/2 && j < n/2)
                        fin[i][j] = q1[i][j];

                    else if(i<n/2 && j>= n/2)
                        fin[i][j] = q2[i][j-n/2];

                    else if(i>=n/2 && j<n/2)
                        fin[i][j] = q3[i-n/2][j] ;
                    else
                        fin[i][j] = q4[i-n/2][j-n/2] ;
                }

        }
        else
        {
            fin[0][0] = a[0][0]*e[0][0] + b[0][0]*g[0][0];
            fin[0][1] = a[0][0]*f[0][0] + b[0][0]*h[0][0];
            fin[1][0] = c[0][0]*e[0][0] + d[0][0]*g[0][0];
            fin[1][1] = c[0][0]*f[0][0] + d[0][0]*h[0][0];
        }

            return fin;
    }

    public static void main(String[] args)
    {
       int[][] m1 = new int[][]{{1,2,3,4},{2,3,4,5},{5,6,7,8},{6,7,8,9}};
        int[][] m2 = new int[][]{{4,2,4,1},{1,2,3,4},{8,7,6,5},{7,9,8,9}};
        int n = m1.length;
        int[][] ans = strassen(m1,m2,n);

        for(int i = 0; i < n;i++)
            for(int j = 0; j< n; j++)
                System.out.println(ans[i][j]);
    }
}
