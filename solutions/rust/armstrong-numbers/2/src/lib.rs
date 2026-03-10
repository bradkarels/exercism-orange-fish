pub fn is_armstrong_number(num: u32) -> bool {
    let digit_count = num.checked_ilog10().map_or(1, |x| x + 1);
    let mut nbr: u32 = num;
    let mut sum: u32 = 0;
    while nbr > 0 {
        let a_digit: u32 = nbr % 10;
        sum += a_digit.pow(digit_count);
        nbr /= 10;
    }
    num == sum
}
