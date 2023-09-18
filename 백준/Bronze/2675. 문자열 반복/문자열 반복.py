T = int(input())
P = ""

for _ in range(T):
    R, S = map(str, input().split())
    R = int(R)
    for i in range(len(S)):
        P = P + (S[i] * R)
    P = P + "\n"
    
print(P)