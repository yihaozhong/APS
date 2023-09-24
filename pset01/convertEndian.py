def convert(n):
    for x in n:
        print(str(x) + " converts to "+ str(int.from_bytes(x.to_bytes(4, byteorder='little', signed = True), byteorder='big', signed=True)))

convert(input())
