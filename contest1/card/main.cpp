#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; ++i) {
            cin >> a[i];
        }

        // Sort the array in non-ascending order
        sort(a.begin(), a.end(), greater<int>());

        long long your_score = 0;

        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) { // Your turn
                if (a[i] > 0) {
                    your_score += a[i];
                }
            } else { // Opponent's turn
                if (a[i] < 0) {
                    your_score += a[i];
                }
            }
        }

        cout << your_score << endl;
    }
    return 0;
}
