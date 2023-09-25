#include <iostream>
#include <string>
#include <vector>

using namespace std;
int main() {
    int t;
    cin >> t;


    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        vector<int> seq(n), b(n);
        for (int j = 0; j < n; ++j) {
            cin >> seq[j];
            if (j == 0) {
                b[j] = (seq[0] == 1) ? 2 : 1;
            } else {
                b[j] = b[j - 1] + 1;
                if (seq[j] == b[j]) {
                    ++b[j];
                }
            }
        }
        cout << b[n - 1] << endl;
    }
    return 0;
}