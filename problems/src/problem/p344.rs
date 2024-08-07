
struct Solution{}

impl Solution {
    pub fn reverse_string(s: &mut Vec<char>) {
        let mut left = 0;
        let mut right = s.len() - 1;

        while left < right {
            s.swap(left, right);
            left+=1;
            right-=1;
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        let mut s = vec!['h','e','l','l','o'];
        Solution::reverse_string(&mut s);
        assert_eq!(vec!['o','l','l','e','h'], s)
    }
}