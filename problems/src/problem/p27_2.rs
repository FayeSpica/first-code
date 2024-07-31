struct Solution{}

impl Solution {
    // 双指针
    pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
        let mut slow_index = 0; // 慢指针定义：新数组下标位置
        let mut fast_index = 0; // 快指针定义：非target元素

        while fast_index < nums.len() {
            if !nums[fast_index].eq(&val) {
                nums[slow_index] = nums[fast_index];
                slow_index += 1;
            }
            fast_index += 1;
        }
        slow_index as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        assert_eq!(2, Solution::remove_element(&mut vec![3,2,2,3], 3))
    }

    #[test]
    pub fn simple_test_case_1() {
        assert_eq!(1, Solution::remove_element(&mut vec![2], 3))
    }
}