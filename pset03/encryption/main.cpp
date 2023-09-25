#include <deque>
#include <iostream>
#include <sstream>
#include <stack>
#include <string>

using namespace std;

int main() {
    string key;
    cin >> key;

    int n;
    cin >> n;

    deque<int> sequence;
    string seq_str, temp;
    cin >> seq_str;

    stringstream ss(seq_str.substr(1, seq_str.length() - 2));
    while (getline(ss, temp, ',')) {
        sequence.push_back(stoi(temp));
    }

    bool flag = false;

    for (char k : key) {
        if (k == 'R') {
            flag = !flag;
        } else if (k == 'D') {
            if (sequence.empty()) {
                cout << "error" << endl;
                return 0;
            }
            if (flag) {
                sequence.pop_back();
            } else {
                sequence.pop_front();
            }
        }
    }

    stringstream output;
    output << "[";

    if (flag) {
        for (auto it = sequence.rbegin(); it != sequence.rend(); ++it) {
            output << *it;
            if (it + 1 != sequence.rend())
                output << ",";
        }
    } else {
        for (auto it = sequence.begin(); it != sequence.end(); ++it) {
            output << *it;
            if (it + 1 != sequence.end())
                output << ",";
        }
    }

    output << "]";
    cout << output.str() << endl;
}
