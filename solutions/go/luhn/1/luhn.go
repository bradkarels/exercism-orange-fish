package luhn

import (
	"strings"
)

func Valid(id string) bool {
	cleanId := strings.Join(strings.Fields(id), "")
	if !isNumeric(cleanId) || len(cleanId) <= 1 {
		return false
	}
	reversed := reverse(cleanId)
	sum := 0
	for i, r := range reversed {
		digit := int(r - '0')
		if i%2 != 0 {
			doubled := digit * 2
			if doubled > 9 {
				adjusted := doubled - 9
				sum += adjusted
			} else {
				sum += doubled
			}
		} else {
			sum += digit
		}
	}
	return sum%10 == 0
}

func reverse(s string) string {
	r := []rune(s)

	for i, j := 0, len(r)-1; i < j; i, j = i+1, j-1 {
		r[i], r[j] = r[j], r[i]
	}

	return string(r)
}

func isNumeric(s string) bool {
	if s == "" {
		return false
	}

	for i := 0; i < len(s); i++ {
		if s[i] < '0' || s[i] > '9' {
			return false
		}
	}

	return true
}
