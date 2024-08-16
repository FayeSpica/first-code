# Day17

## p654
```rust
// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None
        }
    }
}
use std::rc::Rc;
use std::cell::RefCell;

pub(crate) struct Solution{}

impl Solution {
    /// 递归构建
    pub fn construct_maximum_binary_tree(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        if nums.len() == 0 {
            return None;
        }
        let right = nums.len() - 1;
        Solution::construct_binary_tree(&nums, 0, right)
    }

    /// 找到最大值的index和value
    pub fn find_max_index(nums: &Vec<i32>, left: usize, right: usize) -> (usize, i32) {
        let mut max_index = left;
        let mut max = nums[max_index];
        for index in left..=right {
            if nums[index] > max {
                max_index = index;
                max = nums[index];
            }
        }
        (max_index, max)
    }

    /// 递归结束条件: left > right
    /// 每轮递归: 
    /// 1. 找到max_index, max_value, 生成root
    /// 2. 递归左子树 [left, max_index - 1]
    /// 3. 递归右子树 [max_index + 1, right]
    /// 4. 返回 root
    pub fn construct_binary_tree(nums: &Vec<i32>, left: usize, right: usize) -> Option<Rc<RefCell<TreeNode>>> {
        if left > right {
            return None;
        }
        let (max_index, max_value) = Solution::find_max_index(&nums, left, right);
        let mut root = TreeNode::new(max_value);
        if max_index > 0 {
            root.left = Self::construct_binary_tree(nums, left, max_index - 1);
        }
        root.right = Self::construct_binary_tree(nums, max_index + 1, right);
        Some(Rc::new(RefCell::new(root)))
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    pub fn simple_test_case() {
        let root = Solution::construct_maximum_binary_tree(vec![3, 2, 1, 6, 0, 5]).unwrap();
        assert_eq!(root.as_ref().borrow().val, 6);
    }
}
```


## p617
```rust
// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
  #[inline]
  pub fn new(val: i32) -> Self {
    TreeNode {
      val,
      left: None,
      right: None
    }
  }
}
use std::rc::Rc;
use std::cell::RefCell;

pub(crate) struct Solution{}

impl Solution {
    pub fn merge_trees(root1: Option<Rc<RefCell<TreeNode>>>, root2: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        Solution::merge_trees_recursive(&root1, &root2)
    }

    pub fn merge_trees_recursive(root1: &Option<Rc<RefCell<TreeNode>>>, root2: &Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        return match &root1 {
            None => {
                match &root2 {
                    None => {
                        None
                    }
                    Some(root2_ref) => {
                        let mut root = TreeNode::new(root2_ref.borrow().val);
                        root.left = Self::merge_trees_recursive(&None, &root2_ref.borrow().left);
                        root.right = Self::merge_trees_recursive(&None, &root2_ref.borrow().right);
                        Some(Rc::new(RefCell::new(root)))
                    }
                }
            }
            Some(root1_ref) => {
                match &root2 {
                    None => {
                        let mut root = TreeNode::new(root1_ref.borrow().val);
                        root.left = Self::merge_trees_recursive(&root1_ref.borrow().left, &None);
                        root.right = Self::merge_trees_recursive(&root1_ref.borrow().right, &None);
                        Some(Rc::new(RefCell::new(root)))
                    }
                    Some(root2_ref) => {
                        let mut root = TreeNode::new(root1_ref.borrow().val + root2_ref.borrow().val);
                        root.left = Self::merge_trees_recursive(&root1_ref.borrow().left, &root2_ref.borrow().left);
                        root.right = Self::merge_trees_recursive(&root1_ref.borrow().right, &root2_ref.borrow().right);
                        Some(Rc::new(RefCell::new(root)))
                    }
                }
            }
        }
    }
}
```


## p700
```rust
// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
  #[inline]
  pub fn new(val: i32) -> Self {
    TreeNode {
      val,
      left: None,
      right: None
    }
  }
}
use std::rc::Rc;
use std::cell::RefCell;

pub(crate) struct Solution{}

impl Solution {
    pub fn search_bst(root: Option<Rc<RefCell<TreeNode>>>, val: i32) -> Option<Rc<RefCell<TreeNode>>> {
        return match &root {
            None => {
                None
            }
            Some(root_ref) => {
                let root_tree = root_ref.borrow();
                if root_tree.val == val {
                    root.clone()
                } else if root_tree.val > val {
                    Self::search_bst(root_tree.left.clone(), val)
                } else {
                    Self::search_bst(root_tree.right.clone(), val)
                }
            }
        }
    }
}
```


## p98
```rust
// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
  #[inline]
  pub fn new(val: i32) -> Self {
    TreeNode {
      val,
      left: None,
      right: None
    }
  }
}
use std::rc::Rc;
use std::cell::RefCell;
pub(crate) struct Solution{}

impl Solution {
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        Self::is_valid_bst_recursive(&root, &mut vec![])
    }

    pub fn is_valid_bst_recursive(root: &Option<Rc<RefCell<TreeNode>>>, stack: &mut Vec<i32>) -> bool {
        return match root {
            None => {
                true
            }
            Some(root_ref) => {
                let root_ref = root_ref.borrow();
                let root_value = root_ref.val;
                if !Self::is_valid_bst_recursive(&root_ref.left, stack) {
                    return false;
                }
                if !stack.is_empty() && stack.last().unwrap() >= &root_value {
                    return false;
                }
                stack.push(root_value);
                if !Self::is_valid_bst_recursive(&root_ref.right, stack) {
                    return false;
                }
                true
            }
        }
    }
}
```