T = int(input())

for _ in range(T):
    C = int(input())
    count_quarter = C//25
    C = C%25
    count_dime = C//10
    C = C%10
    count_nickel = C//5
    C = C%5
    count_penny = C//1
    print(count_quarter, count_dime, count_nickel, count_penny, sep=' ')