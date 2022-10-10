print("Enter a Number: ")
num = int(input())

rev = 0
while num!=0:
  rem = num%10
  rev = rem + (rev*10)
  num = int(num/10)

print("\nReverse =", rev)