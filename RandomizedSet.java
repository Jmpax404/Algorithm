import java.util.*;

public class RandomizedSet {
    private List<Integer> list = new ArrayList<>();//值是val，下标存到了map
    private Map<Integer, Integer> map = new HashMap<>();//key是val，vaule是list的下标
    private Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.remove(val);
        //把最后一个替换中间的
        int lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        list.remove(list.size() - 1);
        if (lastValue != val) {//只有一个元素的情况
            map.put(lastValue, index);
        }
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}