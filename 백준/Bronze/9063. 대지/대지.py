import sys

N = int(sys.stdin.readline())
widths = []
heights = []

for _ in range(N):
    w, h = map(int, sys.stdin.readline().split())
    widths.append(w)
    heights.append(h)

width = max(widths) - min(widths)
height = max(heights) - min(heights)
area = width * height

print(area)