package org.faye.score1400_1600;

public class P1198 {

    // java 计数排序 O(N**2)
    public int smallestCommonElement(int[][] mat) {
        int[] countArr = new int[10001];

        for (int i = 0; i < mat.length; i++  ) {
            for (int j = 0; j < mat[0].length; j++) {
                // 对每个元素 计数
                countArr[mat[i][j]]++;
            }
        }

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == mat.length) {
                return i;
            }
        }

        return -1;
    }

    // O(N**4) 超时
    public int smallestCommonElement0(int[][] mat) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++  ) {
            for (int j = 0; j < mat[0].length; j++) {
                // 对每个元素 在每行找是否存在 O(N**4)
                if (mat[i][j] < smallest) {
                    int existCount = 0;
                    for (int ii = 0; ii < mat.length; ii++) {
                        for (int jj = 0; jj < mat[0].length; jj++) {
                            if (mat[ii][jj] == mat[i][j]) {
                                existCount++;
                                break;
                            }
                        }
                    }
                    if (existCount == mat.length) {
                        smallest = mat[i][j];
                    }
                }
            }
        }

        if (smallest == Integer.MAX_VALUE) {
            smallest = -1;
        }
        return smallest;
    }
}
