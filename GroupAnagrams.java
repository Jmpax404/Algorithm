import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String strSorted = new String(cs);
            List<String> list = map.get(strSorted);
            if (list == null) {
                map.put(strSorted, new ArrayList<String>() {{
                    add(str);
                }});
            } else {
                list.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        new Solution().groupAnagrams(new String[]{"grvsg", "grsvg"});
    }
}


