#include <stdio.h>
#include <string.h>

int main() {
    char s[1024];
    while (~scanf("%s", s)) {
        int n = strlen(s);
        int j = 1;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += (s[i] - '0') * (  (1 << j) - 1);//char number => - '0'
            j++;
        }
        printf("%d\n", ans);
    }
    return 0;
}
