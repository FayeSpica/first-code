package org.faye.c425;

public class P3 {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        // 贪心，每步找最大discount
        boolean[] op1Visited = new boolean[nums.length];
        boolean[] op2Visited = new boolean[nums.length];

        // 一定消耗完op能最小
        while (op1 != 0 || op2 != 0) {
            // choose max op
            int[] op1Res = getOp1(nums, op1Visited, op1); // 0 index , 1 discount -1 if no, 2 final value
            int[] op2Res = getOp2(nums, k, op2Visited, op2);
            if (op1Res[0] != -1 && op2Res[0] != -1) {
                // chose max
                if (op2Res[1] == op1Res[1]) {
                    // chose todo
                    op2--;
                    nums[op2Res[0]] = op2Res[2];
                    op2Visited[op2Res[0]] = true;
                } else if (op1Res[1] < op2Res[1]) {
                    // chose op2
                    op2--;
                    nums[op2Res[0]] = op2Res[2];
                    op2Visited[op2Res[0]] = true;
                } else {
                    // chose op1
                    op1--;
                    nums[op1Res[0]] = op1Res[2];
                    op1Visited[op1Res[0]] = true;
                }
            } else if (op1Res[0] != -1) {
                //
                op1--;
                nums[op1Res[0]] = op1Res[2];
                op1Visited[op1Res[0]] = true;
            } else if (op2Res[0] != -1) {
                op2--;
                nums[op2Res[0]] = op2Res[2];
                op2Visited[op2Res[0]] = true;
            } else {
                System.out.println("error");
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int[] getOp1(int[] nums, boolean[] op1Visited, int limit) {
        int max_index = -1;
        int max_discount = -1;
        int final_value = -1;

        if (limit == 0) {
            return new int[]{max_index, max_discount, final_value};
        }

        for (int i = 0; i < nums.length; i++) {
            if (!op1Visited[i]) {
                int value = nums[i] / 2;
                if (nums[i] % 2 != 0) {
                    value++;
                }
                int discount = nums[i] - value;
                if (discount > max_discount) {
                    max_discount = discount;
                    max_index = i;
                    final_value = value;
                }
            }
        }
        return new int[]{max_index, max_discount, final_value};
    }

    public int[] getOp2(int[] nums, int k, boolean[] op2Visited, int limit) {
        int max_index = -1;
        int max_discount = -1;
        int final_value = -1;

        if (limit == 0) {
            return new int[]{max_index, max_discount, final_value};
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k && !op2Visited[i]) {
                int value = nums[i] - k;
                int discount = nums[i] - value;
                if (discount > max_discount) {
                    max_discount = discount;
                    max_index = i;
                    final_value = value;
                }
            }
        }
        return new int[]{max_index, max_discount, final_value};
    }

    public static void main(String[] args) {
//        System.out.println(new P3().minArraySum(new int[]{2,8,3,19,3}, 3, 1, 1));
        System.out.println(new P3().minArraySum(new int[]{2,4,3}, 3, 2, 1));
    }
}
