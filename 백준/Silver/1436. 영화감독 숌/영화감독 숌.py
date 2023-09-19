N = int(input())

int_title = 666
titles = []

while len(titles) < N:
    str_title = str(int_title)
    for i in range(len(str_title)-2):
        if str_title[i:i+3] == "666":
            titles.append(str_title)
            break
            
    int_title += 1

print(titles[-1])
