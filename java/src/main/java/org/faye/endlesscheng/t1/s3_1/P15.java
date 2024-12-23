package org.faye.endlesscheng.t1.s3_1;

import java.util.*;

public class P15 {

    public static class Triple {
        public int a;
        public int b;
        public int c;

        public Triple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Triple triple = (Triple) o;
            return a == triple.a && b == triple.b && c == triple.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        // -4 -1 -1 0 1 2
        List<List<Integer>> res = new ArrayList<>();
        Set<Triple> visited = new HashSet<>();


        for (int target = 0; target < nums.length - 1; target++) {
            int left = target + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] + nums[target] == 0) {
                    Triple triple = new Triple(nums[target], nums[left], nums[right]);
                    if (!visited.contains(triple)) {
                        res.add(Arrays.asList(nums[target], nums[left], nums[right]));
                        visited.add(triple);
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[target] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
