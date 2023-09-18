import sys

grade_std = {"A+": 4.5, "A0": 4.0, "B+": 3.5, "B0": 3.0, "C+": 2.5, "C0": 2.0, "D+": 1.5, "D0": 1.0, "F":0.0}

total_credit = 0
major_grade = 0

for i in range(20):
    object_name, credit, grade = (sys.stdin.readline().split())
    if grade == "P":
        continue
    major_grade += float(credit) * grade_std[grade]
    total_credit += float(credit)

answer = major_grade/total_credit
print("%.6f" %answer)