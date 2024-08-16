mod p704;
mod p704_2;
mod p27;
mod p27_2;
mod p209;
mod p344;
mod p541;
mod p151;
mod p654;
mod p617;
mod p700;
mod p98;

pub fn exec() {
    println!("Hello, world!");
    let root = crate::problem::p654::Solution::construct_maximum_binary_tree(vec![3, 2, 1, 6, 0, 5]).unwrap();
}