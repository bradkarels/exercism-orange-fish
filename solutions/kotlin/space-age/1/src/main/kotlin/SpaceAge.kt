class SpaceAge(val ageInSeconds: Int) {

    val earthYearInSeconds: Double = 60 * 60 * 24 * 365.25

    val ageInEarthYears = ageInSeconds / earthYearInSeconds

    fun onEarth(): Double = ageInEarthYears
    fun onMercury(): Double = ageInEarthYears / 0.2408467
    fun onVenus(): Double = ageInEarthYears / 0.61519726
    fun onMars(): Double = ageInEarthYears / 1.8808158
    fun onJupiter(): Double = ageInEarthYears / 11.862615
    fun onSaturn(): Double = ageInEarthYears / 29.447498
    fun onUranus(): Double = ageInEarthYears / 84.016846
    fun onNeptune(): Double = ageInEarthYears / 164.79132
}
