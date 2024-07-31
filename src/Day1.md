# Day1

## p704

```rust
struct Solution{}

use std::cmp::Ordering;
impl Solution {
    // 左闭右闭
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let mut left: i32 = 0;
        let mut right: i32 = (nums.len() - 1) as i32;

        while left <= right {
            let mid = right + left / 2;
            match nums[mid as usize].cmp(&target) {
                Ordering::Less => left = mid + 1,
                Ordering::Equal => return mid,
                Ordering::Greater => right = mid - 1,
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
```

## p704
```rust
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
```

## p27
```rust
struct Solution{}

impl Solution {
    // 暴力解
    pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
        let mut res: usize = nums.len();
        let mut i = 0;
        // 动态遍历结果集大小
        while i < res {
            if nums[i].eq(&val) {
                // 如果遍历到target，结果集-1
                res -= 1;
                // 将target交换出结果集
                nums.swap(i, res);
            } else {
                // 非target，遍历下一个
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
```

## p27
```rust
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
```