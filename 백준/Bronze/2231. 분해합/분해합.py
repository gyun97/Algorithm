N = int(input())

N_str = str(N)

M = 0
constructors = []

for i in range(N):
   i_str = str(i)
   for j in range(len(i_str)):
      M += int(i_str[j])
   if N - M == i:
      constructors.append(i)
   else:
      M = 0

if constructors:
   print(min(constructors))

else:
   print(0)
