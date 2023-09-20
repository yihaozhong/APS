def test(arr):
    stack = []
    res = []
    for i in range(0, len(arr)):
        while stack and stack[-1] >= arr[i]:
            stack.pop()
        if not stack:
            res.append(None)
        else:
            res.append(stack[-1])
        stack.append(arr[i])
    return res
print(test([1, 4, 6, 13, 6, 19, 10]))


def inOrderTraversal(node):
    if node is None:
        return
    
    inOrderTraversal(node.left)
    print(node.val)
    inOrderTraversal(node.right)
    