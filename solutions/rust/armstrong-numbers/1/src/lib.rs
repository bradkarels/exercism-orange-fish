pub fn is_armstrong_number(num: u32) -> bool {
    let mut nbr = num.clone();
    let the_len: u32 = num.to_string().len() as u32;
    let mut sum: u32 = 0;
    while nbr > 0 {
        let a_digit: u32 = nbr % 10;
        sum += a_digit.pow(the_len);
        nbr = nbr / 10;
    }
    num == sum
}
