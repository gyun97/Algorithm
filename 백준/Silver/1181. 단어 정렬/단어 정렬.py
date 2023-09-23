N = int(input())
words = set()

for _ in range(N):
    word = input()
    if word not in words:
        words.add((len(word), word))

words = sorted(words, key=lambda k:(k[0], k[1]))

for i in range(len(words)):
    print(words[i][1])
