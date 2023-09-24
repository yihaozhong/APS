def split(n: int):
    left, right = '', ''
    flag = True
    for i in bin(n)[2:]:
        if i == '0':
            left += i
            right += i
        elif i == '1':
            if flag == True:
                left += i
                right += '0'
            else:
                right += i
                left += '0'
            flag = ~flag

    return left, right

print(split(6))
print(split(7))
print(split(13))
print(split(int('110110101', 2)))

def split_bitwise(n):
    num_bits = n.bit_length()
    
    even_mask = 0
    for i in range(0, num_bits, 2):
        even_mask |= (1 << i)
    odd_mask = even_mask << 1
    
    a = n & even_mask
    b = n & odd_mask
    
    return a, b
print(split_bitwise(6))
print(split_bitwise(7))
print(split_bitwise(13))
