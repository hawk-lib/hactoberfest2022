package main

import "fmt"

func main() {
	fmt.Println("Enter first number: ")
	var first int = 51
	fmt.Scanf("%d", &first)

	fmt.Println("Enter second number: ")
	var second int = 44
	fmt.Scanf("%d", &second)

	fmt.Println("Sum of numbers= ", first+second)
	fmt.Println("Difference of numbers= ", first-second)
	fmt.Println("Product of numbers= ", first*second)
	fmt.Println("Quotient of numbers= ", first/second)
	fmt.Println("Mod of numbers= ", first%second)
}
