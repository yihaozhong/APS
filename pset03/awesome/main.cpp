#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<bool> sieve(int n) {
    vector<bool> primes(n + 1, true);
    for (int i = 2; i * i <= n; ++i) {
        if (primes[i]) {
            for (int j = i * i; j <= n; j += i) {
                primes[j] = false;
            }
        }
    }
    return primes;
}

int main() {
    int n;
    cin >> n;
    int cnt = 0;
    vector<bool> primes = sieve(n);
    if (n < 11) {
        cout << 0 << endl;
        return 0;
    }
    for (int i = 11; i <= n; ++i) {
        if (primes[i] && i % 10 == 1) {
            cnt++;
        }
    }
    cout << cnt << endl;
    return 0;
}