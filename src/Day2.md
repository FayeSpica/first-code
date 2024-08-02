# Day2

## p209

```rust
struct Solution{}

impl Solution {
    // 滑动窗口
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        let mut min_len = 0;

        let mut left = 0;
        let mut right = 0;

        let mut sum = nums[left];

        while left < nums.len() && right < nums.len() {
            if sum >= target {

                let len = right as i32 - left as i32 + 1;
                if min_len == 0 || len < min_len {
                    min_len = len;
                }

                sum -= nums[left];
                left += 1;
                if right < left {
                    right = left;
                }
            } else {
                right += 1;
                if right < nums.len() {
                    sum += nums[right];
                }
            }
        }

        min_len
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        assert_eq!(2, Solution::min_sub_array_len(7, vec![2,3,1,2,4,3]))
    }

    #[test]
    pub fn simple_test_case2() {
        assert_eq!(1, Solution::min_sub_array_len(4, vec![1,4,4]))
    }

    #[test]
    pub fn simple_test_case3() {
        assert_eq!(0, Solution::min_sub_array_len(11, vec![1,1,1,1,1,1,1,1]))
    }
}
```