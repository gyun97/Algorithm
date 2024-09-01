def solution(sizes):
    length = height = 0
    
    for size in sizes:
        length = max(length, max(size[0], size[1]))
        height = max(height, min(size[0], size[1]))
        
    return length * height
        