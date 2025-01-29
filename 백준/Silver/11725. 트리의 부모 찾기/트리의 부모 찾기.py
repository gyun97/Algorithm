import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())  # 노드 수

graph = [[] for _ in range(N + 1)]
parent = [0] * (N + 1)
parent[1] = -1

for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def find_parent(node):
    for next in graph[node]:
        if parent[next] == 0:
            parent[next] = node
            find_parent(next)


find_parent(1)


# list(map(print, parent[2:N+1]))
print("\n".join(map(str, parent[2:N+1])))
