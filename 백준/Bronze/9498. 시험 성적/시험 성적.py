score = int(input())

if 90 <= score <= 100:
    print("A")
elif score//10 == 8:
    print("B")
elif score//10 == 7:
    print("C")
elif score >= 60:
    print("D")
else:
    print("F")