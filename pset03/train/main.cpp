#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;

    while (true)
    {
        int first;
        cin >> first;
        if (first == 0)
            break;
        vector<int> seq(n);
        // int seq[n];
        seq[0] = first;
        for (int i = 1; i < n; ++i)
        {
            cin >> seq[i];
        }
        if (seq[0] == 0)
            break;

        stack<int> mystack;
        int j = 0;
        for (int i = 1; i <= n; ++i)
        {

            mystack.push(i);
            while (!mystack.empty() && j < n && mystack.top() == seq[j])
            {
                mystack.pop();
                ++j;
            }
        }
        cout << (mystack.empty() ? "Yes" : "No") << endl;
    }

    return 0;
}
