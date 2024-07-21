public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] cs1 = s1.toCharArray();//ab
        char[] cs2 = s2.toCharArray();//eidbaooo
        int n1 = cs1.length;
        int n2 = cs2.length;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int totalType = 0;
        int curType = 0;
        for (int i = 0; i < n1; i++) {
            int index = cs1[i] - 'a';
            if (count1[index] == 0) {
                totalType++;
            }
            count1[index]++;
        }

        int i = 0, j = 0;
        boolean shrink;//是否提前缩小

        while (i < n2) {
            shrink = false;
            int index = cs2[i] - 'a';


            if (count1[index] > 0) {
                count2[index]++;
                if (count2[index] == count1[index]) {
                    curType++;
                } else if (count2[index] > count1[index]) {
                    curType--;
                    shrink = true;
                }
            } else {
                shrink = true;
            }
            i++;

            //j<i保证了j不会超过i; curType == totalType符合条件
            while (j < i && (shrink || curType == totalType)) {//其余情况都是一路缩到j==i
                if (!shrink) {//说明curType == totalType且没有经过shrink变量标记
                    return true;
                }
                int indexJ = cs2[j] - 'a';
                if (count2[indexJ] > 0) {
                    if (count2[indexJ] == count1[indexJ]) {
                        curType--;
                    } else if (count2[indexJ] == count1[indexJ] + 1) {
                        curType++;
                        shrink = false;//只把异常部分缩了
                    }
                    count2[indexJ]--;
                }

                j++;
            }

        }

        return false;

    }
}