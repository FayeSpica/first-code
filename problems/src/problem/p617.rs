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