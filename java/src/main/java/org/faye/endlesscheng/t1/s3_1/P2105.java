package org.faye.endlesscheng.t1.s3_1;

public class P2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length - 1;

        int count = 0;

        int currentA = capacityA;
        int currentB = capacityB;

        while (left <= right) {
            if (left == right) {
                if (currentA == currentB || currentA > currentB) {
                    // use a
                    if (currentA < plants[left]) {
                        count++;
                    }
                } else {
                    // use b
                    if (currentB < plants[left]) {
                        count++;
                    }
                }
                break;
            }
            if (currentA < plants[left]) {
                currentA = capacityA;
                count++;
            }
            currentA -= plants[left];

            if (currentB < plants[right]) {
                currentB = capacityB;
                count++;
            }
            currentB -= plants[right];
            left++;
            right--;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
