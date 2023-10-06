def count(S, m, n):
    table = [0] * (n + 1)
    table[0] = 1  # Initialize the number of ways to make change for 0

    for i in range(m):
        for j in range(S[i], n + 1):
            table[j] += table[j - S[i]]

    return table[n]

# Driver program to test above function
arr = [1, 2, 3]
m = len(arr)
n = 4
print(count(arr, m, n))
