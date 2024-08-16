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