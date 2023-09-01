total_price = int(input())
total_quantity = int(input())

price_count = 0

for i in range(total_quantity):
    price, quantity = map(int, input().split())
    price_count += price * quantity

print("Yes") if total_price == price_count else print("No")