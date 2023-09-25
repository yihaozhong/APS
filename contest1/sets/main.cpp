#include <algorithm>
#include <iostream>
#include <sstream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

string hashSet(const unordered_set<int> &s) {
    stringstream ss;
    for (const auto &elem : s) {
        ss << elem << ',';
    }
    return ss.str();
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<unordered_set<int>> sets(n);
        unordered_set<int> U;
        unordered_set<string> attainableSets;

        // Read each Si and populate U
        for (int i = 0; i < n; ++i) {
            int m;
            cin >> m;

            for (int j = 0; j < m; ++j) {
                int x;
                cin >> x;
                sets[i].insert(x);
                U.insert(x);
            }
        }

        // Generate all combinations of Si subsets using bitwise manipulation
        for (int mask = 1; mask < (1 << n); ++mask) {
            unordered_set<int> S;

            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    S.insert(sets[i].begin(), sets[i].end());
                }
            }

            // Check if S is not equal to U or any Si
            if (S != U && find(sets.begin(), sets.end(), S) == sets.end()) {
                attainableSets.insert(hashSet(S));
            }
        }

        // Find the largest set in attainableSets
        int maxSize = 0;
        for (const auto &hash : attainableSets) {
            maxSize = max(maxSize, (int)count(hash.begin(), hash.end(), ','));
        }

        cout << maxSize << endl;
    }

    return 0;
}
