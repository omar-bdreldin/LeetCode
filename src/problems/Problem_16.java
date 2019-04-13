package problems;

public class Problem_16 {

    // return the sum three
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = 0;
        int returnSum = 0;
        boolean firstIter = true;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(sum - target);
                    if (firstIter) {
                        firstIter = false;
                        minDiff = diff;
                        returnSum = sum;
                    } else {
                        if (diff < minDiff) {
                            minDiff = diff;
                            returnSum = sum;
                        }
                    }
                }
            }
        }
        return returnSum;
    }
}
