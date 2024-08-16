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