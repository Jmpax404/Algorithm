class Solution {

    public int[] twoSum1(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (numbers[i] + numbers[m] > target) {
                j = m - 1;
            } else if (numbers[m] + numbers[j] < target) {
                i = m + 1;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                /*
                numbers[i] == numbers[j]
                 */
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{0, 0};
    }


    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int t = numbers[i] + numbers[j];
            if (t > target) {
                int l = i + 1;
                int r = j;
                int base = target - numbers[i];
                while (l < r) {
                    int m = (l + r) >>> 1;
                    if (numbers[m] > base) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                j = l - 1;
            } else if (t < target) {
                int l = i;
                int r = j - 1;
                int base = target - numbers[j];
                while (l < r) {
                    int m = (l + r) >>> 1;
                    if (numbers[m] >= base) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                i = l;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{0, 0};
    }

}