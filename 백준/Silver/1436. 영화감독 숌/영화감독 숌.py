N = int(input())
title = 666
count_6 = 0

while True:
    if "666" in str(title):
        count_6 += 1

    if count_6 == N:
        print(title)
        break

    title += 1
