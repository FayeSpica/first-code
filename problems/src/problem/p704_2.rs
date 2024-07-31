struct Solution{}

use std::cmp::Ordering;
impl Solution {
    // 左闭右开
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let mut left: i32 = 0;
        let mut right: i32 = nums.len() as i32;

        while left < right {
            let mid = right - 1 + left / 2;
            match nums[mid as usize].cmp(&target) {
                Ordering::Less => left = mid + 1,
                Ordering::Equal => return mid,
                Ordering::Greater => right = mid,
            }
        }

        -1
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        assert_eq!(4, Solution::search(vec![-1,0,3,5,9,12], 9))
    }
}