alphabet_list = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"]

word = input()

word_list = list(word)
transform_word = []

for i in range(len(word_list)):
    for j in range(8):
        if word_list[i] in alphabet_list[j]:
            num_word = j + 2
            transform_word.append(num_word)

total_time = 0

for k in transform_word:
    total_time += 2 + (k-1) * 1

print(total_time)