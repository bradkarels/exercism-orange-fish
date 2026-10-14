// Package leap is used to determine if a year is a leap year.
package leap

// IsLeapYear should have a comment documenting it.
func IsLeapYear(year int) bool {
	if year%4 == 0 {
		if year%100 == 0 {
			if year%400 == 0 {
				return true
			} else {
				return false
			}
		}
		return true
	}
	return false
}
