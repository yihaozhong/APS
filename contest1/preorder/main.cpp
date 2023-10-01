// Given the pre-order traversal of a binary search tree, you task is to find the post-order traversal of
#include <iostream>
#include <string>
#include <vector>

using namespace std;
void find(int pre[], int n, int minVal, int maxVal, int &index) {
    if (index == n) {
        return;
    }
    if (pre[index] < minVal || pre[index] > maxVal) {
        return;
    }

    int val = pre[index];
    index++;
    find(pre, n, minVal, val, index);
    find(pre, n, val, maxVal, index);

    cout << val << endl;
}

void findPost(int pre[], int n) {
    int preindex = 0;
    find(pre, n, -10000, 10000, preindex);
}
int main() {
    int n;
    int cnt = 0;
    int tree[10000];
    while (cin >> n) {
        tree[cnt] = n;
        // cout << tree[cnt];
        cnt += 1;
    }

    int size = sizeof(tree) / sizeof(tree[0]);
    findPost(tree, size);
    return 0;
}