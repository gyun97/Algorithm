T = int(input())


for _ in range(T):
    case = input()
    total_score = 0
    combo_socre = 0
    for i in range(len(case)):
        prev = max(0, i - 1)
        if case[i] == "O" and case[prev] == "O":
            combo_socre += 1
            total_score += combo_socre
            
        elif case[i] == "O" and case[prev] == "X":
            combo_socre = 1
            total_score += combo_socre
            
        else:
            combo_socre = 1
            
    print(total_score)