
while True:
    first, second = map(int, input().split())

    if first == 0 and second == 0:
        break
    elif second % first == 0:
        print("factor")
        continue
    elif first % second == 0:
        print("multiple")
        continue
    else:
        print("neither")
        continue