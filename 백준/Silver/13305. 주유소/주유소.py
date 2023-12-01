from sys import stdin


city_num = int(stdin.readline().strip())
road_dis = list(map(int, stdin.readline().split()))
price_L = list(map(int, stdin.readline().split()))
min = price_L[0]
cost = 0

for i in range(city_num - 1):
    if price_L[i] < min:
        min = price_L[i]
    cost += min * road_dis[i]

print(cost)
