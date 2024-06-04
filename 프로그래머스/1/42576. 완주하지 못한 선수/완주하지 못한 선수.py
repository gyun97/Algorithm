def solution(participant, completion):
    hm = dict()
    # answer = ""
    for player in participant:
        if player not in hm.keys():
            hm[player] = 1
        else:
            hm[player] += 1

    for player in completion:
        if player in hm.keys():
            hm[player] -= 1

    for name in hm.keys():
        if hm[name] != 0:
            answer = name

    return answer





