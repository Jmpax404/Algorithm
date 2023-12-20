import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            int a = nums[i];
            Integer value = map.get(target - a);
            if (value != null) {
                return new int[]{i, value};
            } else {
                map.put(a, i);
            }
        }
        return new int[0];
    }


    class Item {
        int v;
        int id;

        public Item(int v, int id) {
            this.v = v;
            this.id = id;
        }

        public int getV() {
            return v;
        }
    }

    public int[] twoSum1(int[] nums, int target) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            items.add(new Item(nums[i], i));
        }

        items.sort(Comparator.comparingInt(Item::getV));
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (items.get(l).v + items.get(r).v == target) {
                return new int[]{items.get(l).id, items.get(r).id};
            } else if (items.get(l).v + items.get(r).v > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }
}