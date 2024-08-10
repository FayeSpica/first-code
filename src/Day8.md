# Day8

## p344

```rust

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
```

## p541

```rust

struct Solution{}

impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        let mut s: Vec<char> = s.chars().collect();
        // 遍历所有[nk,(n+2)k - 1] 取[nk, (n+1)k - 1]
        // (n+2)k - 1 >= s.len() - 1
        // n >= s.len()/k - 2
        let k = k as usize;

        let max_n = s.len() / k + 1;
        let mut n = 0;
        while n <= max_n {
            let mut left = n * k;
            let mut right = (n+1) * k - 1;
            if left >= s.len() {
                break;
            }
            // println!("swap({},{})", left, right);
            if right >= s.len() {
                right = s.len() - 1;
            }

            while left < right {
                s.swap(left, right);
                left+=1;
                right-=1;
            }
            n+=2;
        }
        s.iter().collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        assert_eq!("bacdfeg", Solution::reverse_str("abcdefg".into(), 2))
    }

    #[test]
    pub fn simple_test_case_2() {
        assert_eq!("bacdfe", Solution::reverse_str("abcdef".into(), 2))
    }

    #[test]
    pub fn simple_test_case_3() {
        assert_eq!("dcba", Solution::reverse_str("abcd".into(), 4))
    }

    #[test]
    pub fn simple_test_case_4() {
        assert_eq!("dcba", Solution::reverse_str("abcd".into(), 5))
    }

    #[test]
    pub fn simple_test_case_5() {
        assert_eq!("fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi", Solution::reverse_str("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl".into(), 39))
    }
}
```

## p54

```rust
todo!()
```