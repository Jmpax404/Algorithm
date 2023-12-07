import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int ni = 100001, nj, nk;
        int nit;
        for (int i = 0, iterEnd = n - 2; i < iterEnd; i++) {
            if ((nit = nums[i]) == ni) {
                continue;
            }
            ni = nit;
            if (ni > 0) {
                break;
            }
            int j = i + 1;
            int k = n - 1;
            int negNi = -ni;
            while (j < k) {
                nj = nums[j];
                nk = nums[k];
                int t = nj + nk;
                int m = (j + k) >>> 1;
                int nm = nums[m];
                if (nj + nm > negNi) {
                    k = m - 1;
                } else if (nm + nk < negNi) {
                    j = m + 1;
                } else if (t > negNi) {
                    k--;
                } else if (t < negNi) {
                    j++;
                } else {
                    res.add(Arrays.asList(ni, nj, nk));
                    while (j < k && nums[++j] == nj) ;
                    while (j < k && nums[--k] == nk) ;
                }
            }

        }
        return res;
    }
}