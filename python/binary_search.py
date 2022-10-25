def binarySearch(arr, x):
	low = 0
	high = len(arr) - 1
	mid = 0
	while low <= high:
		mid = (high + low) // 2
		if arr[mid] < x:
			low = mid + 1
		elif arr[mid] > x:
			high = mid - 1
		else:
			return mid
	return -1


# input array be like:2 5 6 4
arr = map(int,input("Enter the array:").split(" ") )
arr=list(arr)
x = int(input("Enter the number to find position:"))
result = binarySearch(arr, x)
if result != -1:
	print("Element is present at index", str(result))
else:
	print("Element is not present in array")
