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