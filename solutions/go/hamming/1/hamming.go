package hamming

import (
	"fmt"
)

func Distance(a, b string) (int, error) {
	lena := len(a)
	lenb := len(b)
	var cnt int = 0
	if lena != lenb {
		return cnt, fmt.Errorf("lengths are different")
	} else {
		ra := []rune(a)
		rb := []rune(b)

		for i, a := range ra {
			if a != rb[i] {
				cnt++
			}
		}
	}
	return cnt, nil
}
