package org.faye.c419;

import java.util.*;

public class P4 {

    static class T {
        int value;
        int freq;

        public T(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            T t = (T) o;
            return value == t.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "T{" +
                    "value=" + value +
                    ", freq=" + freq +
                    '}';
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        long[] res = new long[nums.length - k + 1];

        HashMap<Integer, Integer> numCounter = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            numCounter.computeIfAbsent(nums[i], a -> 0);
        }

        TreeSet<T> top = new TreeSet<>((a, b) -> {
            if (a.freq == b.freq) {
                return - a.value + b.value;
            } else {
                return - a.freq + b.freq;
            }
        });

        TreeSet<T> rest = new TreeSet<>((a, b) -> {
            if (a.freq == b.freq) {
                return - a.value + b.value;
            } else {
                return - a.freq + b.freq;
            }
        });

        long topSum = 0;
        long fullSum = 0;
        int i = 0;

        for (; i < k; i++) {
            int num = nums[i];
            int numCount = numCounter.get(num) + 1;
            numCounter.put(num, numCount);
            T t = new T(num, numCount);
            T tHashed = new T(num, numCount - 1);

            rest.remove(tHashed);
            rest.add(t);
            fullSum += num;
        }

        while (top.size() < x && !rest.isEmpty()) {
            T t = rest.pollFirst();
            top.add(t);
            topSum += (long) t.value * t.freq;
        }

        if (top.size() < x) {
            // use full
            res[0] = fullSum;
        } else {
            // use top
            res[0] = topSum;
        }

        for (; i < nums.length; i++) {
            int num = nums[i];
            int numCount = numCounter.get(num) + 1;
            numCounter.put(num, numCount);
            T addT = new T(num, numCount);
            T addTHashed = new T(num, numCount - 1);

            num = nums[i - k];
            numCount = numCounter.get(num) - 1;
            numCounter.put(num, numCount);
            T removeT = new T(num, numCount);
            T removeTHashed = new T(num, numCount + 1);

            if (addT.value == removeT.value) {
                if (top.size() < x) {
                    // use full
                    res[i - k + 1] = fullSum;
                } else {
                    // use top
                    res[i - k + 1] = topSum;
                }
                continue;
            }

            fullSum += addT.value;
            fullSum -= removeT.value;

            // removeT
            if (removeT.freq == 0) {
                if (top.contains(removeTHashed)) {
                    top.remove(removeTHashed);
                    topSum -= removeT.value;
                }
                rest.remove(removeTHashed);

                if (top.size() < x && !rest.isEmpty()) {
                    T restFirst = rest.pollFirst();
                    topSum += (long) restFirst.value * restFirst.freq;
                    top.add(restFirst);
                }
            } else {
                if (rest.contains(removeTHashed)) {
                    rest.remove(removeTHashed);
                    rest.add(removeT);
                } else if (top.contains(removeTHashed)) {
                    top.remove(removeTHashed);
                    top.add(removeT);
                    topSum -= removeT.value;

                    if (top.last().value == removeT.value) {
                        // compare with restFirst
                        if (!rest.isEmpty()) {
                            T restFirst = rest.first();
                            if ((restFirst.freq > removeT.freq) || (restFirst.freq == removeT.freq && restFirst.value > removeT.value)) {
                                // swap
                                rest.pollFirst();
                                top.pollLast();
                                top.add(restFirst);
                                rest.add(removeT);
                                topSum -= (long) removeT.value * removeT.freq;
                                topSum += (long) restFirst.value * restFirst.freq;
                            }
                        }
                    }
                }
            }

            // addT
            if (top.contains(addTHashed)) {
                topSum += addT.value;
                top.remove(addTHashed);
                top.add(addT);
            } else {
                if (top.size() < x) {
                    topSum += (long) addT.value * addT.freq;
                    top.add(addT);
                } else {
                    // compare with topLast
                    T topLast = top.last();

                    // addT < topLast
                    if (topLast.freq > addT.freq || (topLast.freq == addT.freq && topLast.value > addT.value)) {
                        // addT add to rest
                        rest.remove(addTHashed);
                        rest.add(addT);
                    } else {
                        // addT > topLast
                        // addT remove from rest
                        rest.remove(addTHashed);

                        // addT add to top
                        rest.add(top.pollLast());
                        top.add(addT);
                        topSum += (long) addT.value * addT.freq;
                        topSum -= (long) topLast.value * topLast.freq;
                    }
                }
            }

//            if (top.size() == 7) {
//                int count = 0;
//                for (T t : top) {
//                    count += t.freq;
//                }
//                for (T t : rest) {
//                    count += t.freq;
//                }
//                if (count != k) {
//                    System.out.println();
//                }
//            }
            if (top.size() < x) {
                // use full
                res[i - k + 1] = fullSum;
            } else {
                // use top
                res[i - k + 1] = topSum;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P4().findXSum(new int[]{1,1,2,2,3,4,2,3}, 6, 2)));
        System.out.println(Arrays.toString(new P4().findXSum(new int[]{3,8,7,8,7,5}, 2, 2)));
//
        System.out.println(Arrays.toString(new P4().findXSum(new int[]{4,5,3,5,2,3,6,6,5,4}, 4, 2)));
        System.out.println(Arrays.toString(new P4().findXSum(new int[]{746317605,98025078,460737041,635785449,460737041,61230047,126984495,460737041,635785449,61230047,98025078,635785449,61230047,763835424,169275643,126984495,746317605,746317605,126984495,413571479,98025078,460737041,413571479,126984495,413571479,169275643,746317605,98025078,506004793,460737041,126984495,460737041,763835424,746317605,126984495,61230047,61230047,763835424,763835424,460737041,460737041,746317605,126984495}, 12, 7)));
    }
}
