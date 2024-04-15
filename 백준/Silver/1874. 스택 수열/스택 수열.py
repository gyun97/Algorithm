import sys

input = sys.stdin.readline

N = int(input())

nums = [x for x in range(1, N + 1)]

stack = []

answer = []

count = 1

for _ in range(N):  
    a = int(input()) 
    while a >= count:  
        stack.append(count)  
        answer.append("+")
        count += 1
    if stack[-1] == a:
        answer.append("-")
        stack.pop()
    else:
        answer = ["NO"]
        break

list(map(lambda x: print(x), answer))
