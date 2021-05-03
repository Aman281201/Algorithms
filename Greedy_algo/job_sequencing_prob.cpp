#include <iostream>

int check_sub_ar(bool ar[], int n)
{
    for(int j = n-1; j >= 0; j--)
    {
        if(ar[j])
            return j;
        if(j == 0)
            return -1;

    }

}
using namespace std;
int main()
{
    int jb_p[] = {20, 15, 10, 5, 1}, d[5] = {2,2,1,3,3};  // sorted profits and deadline time of 5 diff jobs
    int i = 0,q = 0, t = 0, s = 0 ;
    int max = 0;

    for(int j = 1; j < sizeof(d)/sizeof(int) - 1; j++)
    {
        if(d[max] < d[j])
            max = j;

    }
    const int g = d[max];
    bool c[g] ;
    for(int j = 0;  j < g; j++)
        c[j] = true;


    while(i < g && q < sizeof(jb_p)/sizeof(int))
    {

        if(c[d[q] - 1])
        {
            t = t + jb_p[q];
            c[d[q] - 1] = false;
            i++;

        }
        else if(d[q] - 1 ==0);

        else if(check_sub_ar(c,d[i] - 1) != -1)
        {

            s = check_sub_ar(c, d[i] - 1);
            t = t + jb_p[q];
            c[s] = false;
            i++;
        }
        q++;
        

    }

cout<<"total profits "<<t;
}