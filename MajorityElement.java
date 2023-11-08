class Solution {
    public int majorityElement(int[] nums) {
   HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                count = 0;
            }
            map.put(nums[i], count + 1);
        }
        int maxVal = 0;
        int maxNum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxNum = entry.getKey();
                maxVal = entry.getValue();
            }
        }
        return maxNum;
    }
}