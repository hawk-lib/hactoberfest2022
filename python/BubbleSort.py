def bubblesort(array):
    for i in range(len(array)-1):
        for j in range(i+1, len(array)):
            if(array[i] > array[j]):
                array[i], array[j] = array[j], array[i]


print("Enter array:")
array = list(map(int, input().split()))
bubblesort(array)
print(*array)
