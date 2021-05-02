package first_prog;
import java.util.Scanner;

public class Mergesort {

	public static int[] mergesort(int[] ar,int n)
	{
		if(n != 1) {
			int n1 = n / 2;
			int n2 = n - n1;
			int[] li1 = new int[n1];
			int[] li2 = new int[n2];

			for (int i = 0; i < n1; i++)
				li1[i] = ar[i];
			for (int i = 0; i < n2; i++)
				li2[i] = ar[n1 + i];

			return merge(mergesort(li1, n1), mergesort(li2, n2), n1, n2);
		}
		else return ar;

	}

	public  static  int[] merge(int[] ar1, int[] ar2, int m, int n)
	{
		int j = 0;
		int k = 0;

		int[] li = new int[n+m];
		for(int i = 0; i < n+m ; i++)
		{
			if (k >= n)
			li[i] = ar1[j++];


			else if (j >= m)
			li[i] = ar2[k++];
			else{
			if (ar1[j] >= ar2[k])
			{
				li[i] = ar2[k];
				k++;
			}
			else {
				li[i] = ar1[j];
				j++;
			}}
		}

		return li;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];

		for(int i =0 ; i< n;i++)
			ar[i] = sc.nextInt();


		ar = mergesort(ar,n);
		for(int i = 0; i< n; i++)
			System.out.println(ar[i]);

	}

}