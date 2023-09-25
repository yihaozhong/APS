#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
    string line;
    getline(cin, line);

    stack<char> mystack;
    int cnt = 1;
    for (char c : line) {
        if (c == '(' || c == '{' || c == '[') {
            mystack.push(c);
        } else if (c == ')' || c == '}' || c == ']') {
            if (mystack.empty()) {
                cout << "NO " << cnt << endl;
                return 0;
            }
            char top = mystack.top();
            if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                cout << "NO " << cnt << endl;
                return 0;
            }
            mystack.pop();
        }
        cnt++;
    }
    if (!mystack.empty()) {
        cout << "NO " << cnt << endl;
    } else {
        cout << "YES" << endl;
    }

    return 0;
}