// Package weather is a package comment that exists.
package weather

var (
	// CurrentCondition is a string that describes a thing.
	CurrentCondition string
	// CurrentLocation is a string that does another thing.
	CurrentLocation string
)

// Forecast is a function.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
