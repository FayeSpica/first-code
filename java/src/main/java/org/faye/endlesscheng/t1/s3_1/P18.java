package org.faye.endlesscheng.t1.s3_1;

import java.util.*;

public class P18 {

    public static class Quadruple {
        public int a;
        public int b;
        public int c;
        public int d;

        public Quadruple(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Quadruple quadruple = (Quadruple) o;
            return a == quadruple.a && b == quadruple.b && c == quadruple.c && d == quadruple.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }

    // todo slow
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<Quadruple> visited = new HashSet<>();
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    long cur = (long)nums[a] + nums[b] + nums[c] + nums[d];
                    if (cur == target) {
                        Quadruple quadruple = new Quadruple(nums[a], nums[b], nums[c], nums[d]);
                        if (!visited.contains(quadruple)) {
                            res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                            visited.add(quadruple);
                        }
                        c++;
                        d--;
                    } else if (cur > target) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P18().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}
