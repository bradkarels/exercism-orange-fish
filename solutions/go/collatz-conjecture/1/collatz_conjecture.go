package collatzconjecture

import "fmt"

func CollatzConjecture(n int) (int, error) {
	if n <= 0 {
		return 0, fmt.Errorf("n must be a positive integer")
	} else {
		nn := n
		steps := 0
		for nn > 1 {
			if nn%2 == 0 {
				nn = nn / 2
			} else {
				nn = (3 * nn) + 1
			}
			steps++
		}
		return steps, nil
	}
}
