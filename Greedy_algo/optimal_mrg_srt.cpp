// optimal merge sort

#include <iostream>

using namespace std;

void sort_last_two(int (*ar), string (*s), int n)
{ int temp, i, min;
  string tmp ;
    for(i = 0;i< 2; i++)
    {   min = 0;
        for(int j = 1; j < n; j++)
        if(ar[min] > ar[j])
                min = j;

        temp = ar[min];
        ar[min] = ar[n-1];
        ar[n-1] = temp;

        tmp  = s[min];
        s[min] = s[n-1];
        s[n-1] = tmp;

        n--;
    }
}




int main()
{
    int len[] = {2, 5, 3, 6, 7, 8}   ;   //be the array containing numbers of elements of n lists
    string name[] = {"A", "B", "C", "D", "E", "F"}; //names of n respective lists


    int temp = 0, a = 0, j = 0, t = 0, n,k;
    string tmp ;
    n = sizeof(len)/sizeof(int);
    k = n;
    while(k > 2)
    {
        sort_last_two(len, name, k);
        for(int i = 0; i < n; i ++)
        cout<<len[i]<<" ";
        len[k-2] = len[k-1] + len[k-2];
        len[k-1] = 0;



        cout<<name[k-1]<<" merged with "<<name[k-2]<<endl;
        name[k-2] = name[k-1] + name[k-2];
        t = t + len[k-2];
        k--;
    }
    t = t + len[0] + len[1];
    cout<<name[0]<<" merged with "<<name[1]<<endl;


    return 0;                                                                                   
}