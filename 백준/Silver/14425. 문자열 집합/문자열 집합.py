import sys

N, M = (map(int, sys.stdin.readline().split()))

string_list = dict()
count = 0

for _ in range(N):
    add_string = sys.stdin.readline().strip()
    string_list[add_string] = 0

for _ in range(M):
    search_string = sys.stdin.readline().strip()
    if search_string in string_list:
        count += 1

print(count)