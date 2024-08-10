# Day9

## p151

```rust

struct Solution{}

impl Solution {
    pub fn swap(s: &mut Vec<char>, left: usize, right: usize) {
        let mut left = left;
        let mut right = right;
        while left < right {
            s.swap(left, right);
            left +=1;
            right -=1;
        }
    }
    pub fn reverse_words(s: String) -> String {
        let mut s: Vec<char> = s.chars().collect();

        if s.len() == 0 {
            return String::new();
        }
        let right = s.len() - 1;
        Solution::swap(&mut s, 0, right);

        let mut res: Vec<char> = vec![];

        // find word
        let mut left = 0;
        let mut right = 0;
        while left < s.len() && s[left] == ' ' {
            left += 1;
        }
        right = left;
        while left < s.len() && right < s.len() {
            if right == s.len() - 1 || s[right+1] == ' ' {
                Solution::swap(&mut s, left, right);
                // copy word
                if !res.is_empty() {
                    res.push(' ');
                }
                for i in left..=right {
                    res.push(s[i]);
                }
                left = right + 2;
                while left < s.len() && s[left] == ' ' {
                    left += 1;
                }
                right = left;
                continue;
            }
            right+=1;
        }

        res.iter().collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        assert_eq!("world hello", Solution::reverse_words("  hello world  ".into()));
        println!("ok")
    }
}
```

## p459

```rust
todo!()
```
