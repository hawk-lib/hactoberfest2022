
def fibonacci(n):
    if n < 0:
        print("Incorrect input")
    elif n == 0:
        return 0
    elif n == 1 or n == 2:
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)
 

a=int(input("Enter the no of terms:"))
for i in range(0,a+1):
    print(fibonacci(i))