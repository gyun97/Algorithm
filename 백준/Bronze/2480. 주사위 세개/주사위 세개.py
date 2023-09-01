import sys

A, B, C = map(int, sys.stdin.readline().split())

dice = A, B, C
prize_money = 0

if A == B == C:
    prize_money = 10000 + A * 1000
elif len(set(dice)) == 2:
    prize_money = 1000 + max(dice, key = dice.count) * 100
else:
    prize_money = max(dice) * 100

print(prize_money)
