#include <iostream>
//#include <string>
using namespace std;

// for implementing tree

struct node {
    int data;
    struct node* left;
    struct node* right;
    node()
    {
        left = NULL;
        right = NULL;
    }
};

void set_codes(node* (root), string code, string (*codes), int count[])
{

    if(root->left == NULL && root->right == NULL)
    {
        for(int i = 0 ; i < 5; i ++)
            if(count[i] == root->data)
                codes[i] = code;
        return;
    }
    else{
    set_codes(root->left, string (code + "0"), string (*codes), int count[]);
    set_codes(root->right, string (code + "1"), string (*codes), int count[]);
}}



void sort_last_two(int s,node* (*x), int start)
{ int  i, min;
    node *temp;
    int end = s;

    for(i = 0;i< 2; i++)
    {   min = end;
        for(int j = end-1; j > start; j--)
        if(x[end - 1]->data < x[end]->data)
            min = end -1;

        temp = x[min];
        x[min] = x[start];
        x[start] = temp;


        end--;
    }
}



int main()
{
    string msg = "abccdeebcdeaabcdebacadbeacdaeadacbacdeabcdaec";
    int count[5] = {0,0,0,0,0}, c[5];

    for(int i = 0; i < msg.size() ; i++)
        switch (msg[i]) {
        case 'a': count[0]++;
                break;
        case 'b': count[1]++;
                break;
        case 'c': count[2]++;
                break;
        case 'd': count[3]++;
                break;
        case 'e': count[4]++;

            default : break;
        }
    for(int i  = 0; i < 5; i++)
        c[i] = count[i];

const int s = sizeof(count)/sizeof(int);

node *n[s];
for(int i = 0; i < s ; i++)
    n[i]->data = count[i];

// creating a tree using optimum mergesort algorithm

int y = sizeof(count)/sizeof(int);
int a = 0;
    while(a < sizeof(count)/sizeof(int) - 1)
    {
        sort_last_two(s, n, a);

        node *root ;


        root->left =  n[a];
        root->right =  n[a+1];


        c[a+1] = c[a] + c[a+1];
        c[a] = 0;
        root->data = c[a+1];
        n[a+1] = root;


    }

    // creating huffmann codes 
    // adding 0 if path taken is left and 1 if path taken is right

    string codes[5];
    set_codes(root, "", codes, count);

    cout<<"the huffmann codes for A , B , C , D , E respectively are\n";

    for(int i = 0; i < 5 ; i++)
        cout<<codes[i]<<" ";


    return 0;
}