while True:
    num = input()
    if num == "0":
        break
    reversed_num = list(reversed(num))
    
    if list(num) == reversed_num:
        print("yes")
    else:
        print("no")
