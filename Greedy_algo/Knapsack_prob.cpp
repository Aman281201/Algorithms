#include <iostream>


using namespace std;

int main() {
    int  x = 0,n = 10,g, max = 0,b = 0,tmp;


    int ar[5] = {2,5,2,1,6}, p[5] = {4,5,6,3,1},q[5] = {0,0,0,0,0};
    float f[5],h[5],temp, t = 0.0;
    for(int i = 0 ; i< sizeof(ar)/sizeof(int);i++)
    {f[i] = p[i]/ar[i];
        h[i]  = f[i];}

    g = 5;
    while(x!= 10)
    {   max = 0;
        b =  1;
        for(int j = 0; j < g -1;j++ )
        {

            if(f[max+b] > f[max])
                max = max + b;
            else b++;
            //cout<<max;

        }


        g--;
        if(x + ar[max] > 10 )
        ar[max] = 10 - x;
        x = x + ar[max];
        t = t + ar[max]*f[max];

        temp = f[g];
        f[g] = f[max];
        f[max] = temp;

        tmp = ar[g];
        ar[g] = ar[max];
        ar[max] = tmp;


    }


cout<<t;



    return 0;
}
