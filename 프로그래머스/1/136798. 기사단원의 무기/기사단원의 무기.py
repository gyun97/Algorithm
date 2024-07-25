def solution(number, limit, power):

    count = [0] * (number + 1)


    for i in range(1, number + 1):
        for j in range(1, (number // i) + 1):
            count[i * j] += 1


    for i in range(len(count)):
        if count[i] > limit:
            count[i] = power
    return sum(count)






