package main 


import (
	"fmt"
	"strings"
	"strconv"
	"log"
	"errors"
)
func main(){
	amountInWords,err := ConvertAmountInIndianWords("10001")
	if err != nil {
		log.Fatal("Error", err)
		return
	}
	fmt.Println(amountInWords)
}

func ConvertToRupees(amount string) (output string) {
	words := make([]string, 91)
	words[0] = "Zero"
	words[1] = "One"
	words[2] = "Two"
	words[3] = "Three"
	words[4] = "Four"
	words[5] = "Five"
	words[6] = "Six"
	words[7] = "Seven"
	words[8] = "Eight"
	words[9] = "Nine"
	words[10] = "Ten"
	words[11] = "Eleven"
	words[12] = "Twelve"
	words[13] = "Thirteen"
	words[14] = "Fourteen"
	words[15] = "Fifteen"
	words[16] = "Sixteen"
	words[17] = "Seventeen"
	words[18] = "Eighteen"
	words[19] = "Nineteen"
	words[20] = "Twenty"
	words[30] = "Thirty"
	words[40] = "Forty"
	words[50] = "Fifty"
	words[60] = "Sixty"
	words[70] = "Seventy"
	words[80] = "Eighty"
	words[90] = "Ninety"

	amountSplit := strings.Split(amount, ".")
	numberSplit := strings.Split(amountSplit[0], ",")
	number := strings.Join(numberSplit, "")

	numberLength := len(number)
	wordString := ""
	if numberLength <= 9 {

		numArr := [9]int{0, 0, 0, 0, 0, 0, 0, 0, 0}

		numRecvdInArr := make([]int, 20)
		for i := 0; i < numberLength; i++ {

			tempNumber, _ := strconv.Atoi(string(number[i]))
			numRecvdInArr[i] = tempNumber
		}

		for i, j := 9-numberLength, 0; i < 9; i, j = i+1, j+1 {
			numArr[i] = numRecvdInArr[j]
		}
		for i, j := 0, 1; i < 9; i, j = i+1, j+1 {

			if i == 0 || i == 2 || i == 4 || i == 7 {
				if numArr[i] == 1 {
					numArr[j] = 10 + numArr[j]
					numArr[i] = 0
				}
			}
		}
		var value int
		for i := 0; i < 9; i++ {

			if i == 0 || i == 2 || i == 4 || i == 7 {
				value = numArr[i] * 10
			} else {
				value = numArr[i]
			}
			if value != 0 {
				wordString += words[value] + " "
			}
			if (i == 1 && value != 0) || (i == 0 && value != 0 && numArr[i+1] == 0) {
				wordString += "Crores "
			}
			if (i == 3 && value != 0) || (i == 2 && value != 0 && numArr[i+1] == 0) {
				wordString += "Lakhs "
			}
			if (i == 5 && value != 0) || (i == 4 && value != 0 && numArr[i+1] == 0) {
				wordString += "Thousand "
			}
			if i == 6 && value != 0 && (numArr[i+1] != 0 && numArr[i+2] != 0) {
				wordString += "Hundred "
			} else if i == 6 && value != 0 {
				wordString += "Hundred "
			}
		}
		wordStringSplit := strings.Split(wordString, " ")
		wordString = strings.Join(wordStringSplit, " ")
	}

	return wordString

}

func ConvertAmountInIndianWords(amount string) (output string, err error) {
	amt, err := strconv.ParseFloat(amount, 64)
	if err != nil {
		fmt.Println("Error", err)
		err = errors.New("Amount is incorrect, Please check the amount")
		return

	}
	if amt > 9999999999.99 {
		err = errors.New("Amount to big to convert")
		return

	}
	nums := strings.Split(amount, ".")
	whole := ConvertToRupees(nums[0])
	if len(nums) > 1 {
		if nums[1] == "" {
			nums[1] = "0"

		}

		if len(nums[1]) == 1 {
			nums[1] = nums[1] + "0"
		}
		if len(nums[1]) > 2 {
			tempNum1 := nums[1]
			nums[1] = tempNum1[0:len(nums)]

		}

	}

	finalOutPut := ""
	if len(nums) >= 1 {
		tempNums, _ := strconv.Atoi(nums[0])

		if tempNums <= 9 {
			nums[0] = strconv.Itoa(tempNums * 10)
		} else {
			nums[0] = nums[0]
		}
		fraction := ""
		if len(nums) == 2 {
			fraction = ConvertToRupees(nums[1])

		}
		if whole == "" && fraction == "" {
			finalOutPut = "Zero only."
		}
		if whole == "" && fraction != "" {
			finalOutPut = fraction + "paise only."
		}
		if whole != "" && fraction == "" {
			finalOutPut = whole + "rupees only."
		}
		if whole != "" && fraction != "" {
			finalOutPut = whole + "rupees and " + fraction + "paise only."
		}

	}
	return finalOutPut, err

}