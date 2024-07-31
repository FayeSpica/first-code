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
```