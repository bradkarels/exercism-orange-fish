package raindrops

import "strconv"

func Convert(number int) string {
	//panic("Please implement the Convert function")
	result := ""
	if number%3 == 0 {
		result = result + "Pling"
	}
	if number%5 == 0 {
		result = result + "Plang"
	}
	if number%7 == 0 {
		result = result + "Plong"
	}
	if result != "" {
		return result
	}
	return strconv.Itoa(number)
}
