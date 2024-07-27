import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        List<Integer> sortedList = new ArrayList<>();
        for (Integer num : nums) {
            sortedList.add(num);
        }
        Collections.sort(sortedList);

        int pre = sortedList.get(0);
        int preCount = 1;
        int dominant = -1;
        int dominantCount = 0;
        int n = sortedList.size();
        for (int i = 1; i < n; i++) {
            if (sortedList.get(i).equals(sortedList.get(i - 1))) {
                preCount++;
            } else {
                if (dominantCount < preCount) {
                    dominant = pre;
                    dominantCount = preCount;
                }
                pre = sortedList.get(i);
                preCount = 1;
            }
        }
        if (dominantCount < preCount) {
            dominant = pre;
            dominantCount = preCount;
        }

        int currentCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i).equals(dominant)) {
                currentCount++;
                if (currentCount * 2 > i + 1 && (dominantCount - currentCount) * 2 > (n - i - 1)) {
                    // Dominant left and dominant right
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> nums = Arrays.asList(999999991,999999996,999999995,1000000000,999999995,999999995,999999995,999999994,1000000000,999999995,999999994,999999998,999999995,999999995,999999997,999999995,999999992,999999995,999999995,999999996,999999995,999999992,999999995,999999995,999999995,999999992,999999995,999999995,999999992,999999995,999999995,999999995,999999995,999999993,999999995,999999991,999999995,1000000000,999999995,999999995,999999995,999999995,999999995,999999995,999999996,999999993,1000000000,999999995,999999991,999999995,999999995,1000000000,1000000000,999999995,999999999,999999995,999999997,999999995,999999995,999999995,999999995,999999995,999999996,999999995,999999997,999999995,999999995,999999996,999999991,999999999,999999991,999999995,999999997,999999995,999999996,999999994,999999995,999999995,999999995,999999991,999999999,999999995,999999995,999999996,999999993,999999997,999999995,999999991,999999993,999999995,999999999,999999995,999999994,999999999,999999995,999999995,999999996,999999993,999999993,999999995,999999995,999999995,999999993,999999995,999999995,999999994,999999994,999999996,999999992,999999995,999999998,999999995,999999993,999999995,999999998,999999996,999999995,999999996,999999995,999999995,999999995,999999995,999999995,999999995,999999995,999999995,999999995,999999997,999999999,999999995,999999995,1000000000,999999995,999999995,999999995,1000000000,999999998,999999991,999999995,999999995,999999995,999999996,1000000000,999999995,999999996,999999992,999999999,999999995,999999995,999999998,999999992,999999999,999999995,999999995,1000000000,999999995,999999998,999999995,999999995,999999995,999999998,999999995,999999995,999999995,999999998,999999995,999999993,999999993,999999995,999999993,999999995,999999999,999999995,999999991,999999995,999999998,999999995,999999997,999999995,999999991,999999995,999999998,999999995,999999995,999999995,999999999,999999995,999999994,999999995,999999994,999999995,999999995,999999992,999999995,999999996,999999992,999999997,999999995,999999995,999999993,999999991,999999995,999999995,999999991,999999995,999999995,999999994,999999995,999999999,999999995,999999995,999999992,999999997,999999995,999999999,999999995,999999997,1000000000,999999999,999999995,999999995,999999995,999999999,999999998,999999998,999999995,999999995,999999995,999999996,999999996,999999995,999999995,999999995,999999995,999999995,999999995,999999999,999999995,999999995,1000000000,999999995,999999995,999999993,999999995,999999996,999999992,1000000000,999999995,999999991,999999997,999999995,999999994,999999995,999999995,999999991,999999995,999999994,999999995,999999998,999999995,999999995,999999994,1000000000,999999996,999999996,999999993,999999995,999999993,999999995,999999991,999999995,999999995,999999996,999999995,999999997,999999998,999999992,999999995,999999991,999999995,1000000000,999999991,999999999,1000000000,999999995,999999995,1000000000,999999996,999999995,999999995,999999994,999999995,999999995,999999995,999999995,999999996,999999999,999999995,999999998,999999995,999999997,999999991,999999995,999999994,999999995,999999991,999999999,999999995,999999995,999999995,999999995,999999995,999999995,999999992,1000000000,999999991,999999995,999999995,999999998,999999995,999999992,1000000000,999999994,999999991,999999995,999999992,999999995,999999993,999999995,999999992,999999994,999999997,999999995,999999992,999999995,999999997,999999997,999999995,999999995,999999995,999999991,999999992,999999995,999999995,999999995,999999997,999999993,999999995,999999999,999999994,999999997,999999995,999999995,999999995,999999995,999999994,999999995,999999991,999999995,999999992,1000000000,999999992,999999995,999999995,999999995,999999995,999999995,999999994,999999996,999999995,999999995,999999995,999999994,999999995,999999997,999999995,999999997,999999995,999999995,999999995,1000000000,999999995,999999996,1000000000,999999996,999999992,999999994,999999995,999999992,999999995,999999995,999999997,999999997,999999995,999999998,999999995,999999998,999999999,999999995,999999996,999999993,999999998,999999995,999999995,999999996,999999991,999999998,999999992,999999991,999999995,999999995,999999994,999999992,999999998,999999995,999999995,999999995,999999997,999999995,1000000000,999999995,999999992,999999998,999999995,999999995,999999991,999999995,999999991,999999992,999999995,999999993,999999998,999999995);
        // List<Integer> nums = Arrays.asList(2,1,3,1,1,1,7,1,2,1);
        System.out.println("test: " + sol.minimumIndex(nums));
    }
}