#include <iostream>
#include <bits/stdc++.h>

using namespace std;

//debugging
#define watch(x) cout << (#x) << " is " << (x) << endl

//datatypes
#define ll long long int
#define vc vector<int>
#define st stack<int>
#define qu queue<int>

//functions
void printV(vector<int> v){for(int i = 0; i < v.size(); i++){cout<<v[i]<<" ";}cout<<endl;}
int binarySearchV( vector<int> v, int l, int r, int x){while(r >= l) {int mid = l + (r - l) / 2;if (v[mid] == x)return mid;else if (v[mid] > x)r = mid -1;else l = mid + 1;}return -1;}


int main() {
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); 

    int t;
    cin>>t;
    
    while(t--)
    {
        
    }

	return 0;
}
