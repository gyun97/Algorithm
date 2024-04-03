import sys

board = sys.stdin.readline().strip()

board = board.replace("XXXX", "AAAA")
board = board.replace("XX", "BB")

print(board) if "X" not in board else print(-1)
