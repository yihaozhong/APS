#include <iostream>
#include <queue>
#include <stack>
#include <vector>

using namespace std;

int main() {
    string s;
    cin >> s;

    // stack<char> mystack;

    // for (char c : s) {
    //     if (c == '<') {
    //         if (!mystack.empty()) {
    //             mystack.pop();
    //         }
    //     } else {
    //         mystack.push(c);
    //     }
    // }

    // // Create an output string to store the result
    // string output = "";
    // while (!mystack.empty()) {
    //     output = mystack.top() + output;
    //     mystack.pop();
    // }

    // cout << output;

    string output = "";

    for (char c : s) {
        if (c == '<') {
            if (!output.empty()) {
                output.pop_back(); // Remove the last character from the string
            }
        } else {
            output.push_back(c); // Add the character to the end of the string
        }
    }

    cout << output;
    return 0;
}