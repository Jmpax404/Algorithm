#include <cstdio>
#include <cmath> 

class Solution {
public:
    int tb[10] = { 0 };
    int cur[10] = { 0 };
    int count = 0;

    void re(int index, int n) {
        if (index == n + 1) {
            count++;
            return;
        } 
        for (int i = 1; i <= n; i++) {
            if (!tb[i]) {
                bool isWrong = false;
                for (int j = 1; j < index; j++) {
                    if (abs(index - j) == abs(i - cur[j])) {
                        isWrong = true;
                        break;
                    }
                }
                if (isWrong) {
                    continue;
                }
                tb[i] = 1;
                cur[index] = i;
                re(index + 1, n);
                tb[i] = 0;
            }
        }
    }

    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    int Nqueen(int n) {
        // write code here
        re(1, n);
        return count;
    }
};

int main() {
    Solution s;
    int count = s.Nqueen(8);
    printf("%d\n", count);
    return 0;
}
