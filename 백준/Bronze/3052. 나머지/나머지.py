remainder_list = []

for _ in range(10):
    num = int(input())
    remainder = num%42
    remainder_list.append(remainder)

print(len(set(remainder_list)))