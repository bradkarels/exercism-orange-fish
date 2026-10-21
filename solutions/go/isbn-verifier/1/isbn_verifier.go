package isbnverifier

import (
	"strings"
	"unicode"
)

func IsValidISBN(isbn string) bool {
	if len(isbn) == 0 || !isValid(isbn) {
		return false
	}
	r := []rune(isbn)
	checkX := unicode.ToLower(r[len(r)-1]) == 'x'
	var cleanISBN string
	if checkX {
		cleanISBN = digitsOnly(string(r[0:len(r)-1])) + string('X')
	} else {
		cleanISBN = digitsOnly(string(r[0:]))
	}

	if len(cleanISBN) != 10 {
		return false
	}
	sum := 0
	for i, j := 0, 10; i <= 9; i, j = i+1, j-1 {
		if i == 9 {
			if checkX {
				sum += 10 // (1 * 10)
			} else {
				digit := int(cleanISBN[i] - '0')
				sum += digit // (1 * digit)
			}
		} else {
			digit := int(cleanISBN[i] - '0')
			sum += digit * j
		}
	}
	return sum%11 == 0
}

func digitsOnly(s string) string {
	var b strings.Builder

	for _, r := range s {
		if unicode.IsDigit(r) {
			b.WriteRune(r)
		}
	}

	return b.String()
}

func isValid(s string) bool {
	for _, r := range s {
		if (r >= '0' && r <= '9') || r == '-' || r == 'X' || r == 'x' {
			continue
		}
		return false
	}
	return true
}
