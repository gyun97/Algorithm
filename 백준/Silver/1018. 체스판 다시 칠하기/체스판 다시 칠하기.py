import sys

N, M = map(int, sys.stdin.readline().split())

my_board = []

for _ in range(N):
   my_board.extend(sys.stdin.readline().split())


black_board = [["B" for _ in range(8)] for _ in range(8)]


for i in range(8):
   for j in range(8):
      if i % 2 != 0:
         black_board[i][0] = "W"

      if black_board[i][0] == "B" and j % 2 != 0:
         black_board[i][j] = "W"
      elif black_board[i][0] == "W" and (j == 0 or j % 2 == 0):
         black_board[i][j] = "W"


black_board = ["".join(row) for row in black_board]


black_list = []

for string in black_board:
    black_list.extend(list(string))

white_board = [["W" for _ in range(8)] for _ in range(8)]

for i in range(8):
   for j in range(8):
      if i % 2 != 0:
         white_board[i][0] = "B"

      if white_board[i][0] == "W" and j % 2 != 0:
         white_board[i][j] = "B"
      elif white_board[i][0] == "B" and (j == 0 or j % 2 == 0):
         white_board[i][j] = "B"

white_board = ["".join(row) for row in white_board]

white_list = []

for string in white_board:
    white_list.extend(list(string))

board = []
different_count = []


for i in range(N-7):
   for j in range(M-7):
      for k in range(i, i+8):
         for l in range(j, j+8):
            board.extend(my_board[k][l])

            if len(board) == 64:
               # print(board)
               different_count.append(sum(1 for x, y in zip(board, black_list) if x != y))
               different_count.append(sum(1 for x, y in zip(board, white_list) if x != y))
               board = []

print(min(different_count))
