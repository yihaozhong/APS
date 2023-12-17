def maxModuloSum(A, K):
    A.sort(reverse=True)
    maxSum = 0
    for i in range(len(A) - 1):
        maxSum += (A[i+1] - A[i]) % K
    return maxSum

# Sample Input
N, K = 3, 4
A = [0, 1, 2]
print(maxModuloSum(A, K))  # Output: 6
