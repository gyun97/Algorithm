import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())
tree = dict()

for _ in range(N):
    parent, left, right = input().split()
    tree[parent] = [left, right]



def pre_order(parent):
    """전위 순회: 부모 노드 -> 왼쪽 노드 -> 오른쪽 노드"""
    if parent != '.':
        print(parent, end="")  # 부모 노드 출력
        pre_order(tree[parent][0])  # 왼쪽 자식 노드 출력
        pre_order(tree[parent][1])  # 오른쪽 자식 노드 출력


def in_order(parent):
    """중위 순회: 왼쪽 노드 -> 부모 노드 -> 오른쪽 노드"""
    if parent != '.':
        in_order(tree[parent][0])  # 왼쪽 자식 노드 출력
        print(parent, end="")  # 부모 노드 출력
        in_order(tree[parent][1])  # 오른쪽 자식 노드 출력


def post_order(parent):
    """후위 순회: 왼쪽 노드 -> 오른쪽 노드 -> 부모 노드"""
    if parent != '.':
        post_order(tree[parent][0])  # 왼쪽 자식 노드 출력
        post_order(tree[parent][1])  # 오른쪽 자식 노드 출력
        print(parent, end="")  # 부모 노드 출력


pre_order('A')
print()
in_order('A')
print()
post_order('A')


