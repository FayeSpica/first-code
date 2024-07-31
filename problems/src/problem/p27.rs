struct Solution{}

impl Solution {
    // 暴力解
    pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
        let mut res: usize = nums.len();
        let mut i = 0;
        while i < res {
            if nums[i].eq(&val) {
                res -= 1;
                nums.swap(i, res);
            } else {
                i += 1;
            }
        }
        res as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        assert_eq!(2, Solution::remove_element(&mut vec![3,2,2,3], 3))
    }
}