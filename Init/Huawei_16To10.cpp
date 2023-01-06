#include<stdio.h>

/*
scanf("%x", &num);
cin>>hex>>num;
*/ 
int main() {
    char s[11];
    scanf("%s", s);
    int d[8], i = 0;
    char c;
    while ((c = s[i + 2]) != '\0') {
        if (c >= 'a') {// 'a' is 0x61
            d[i] = c - 0x57;
        } else if (c >= 'A') {// 'A' is 0x41
		//'A' is not adjacent to '0'
            d[i] = c - 0x37;
        } else {// 0 is 0x30
            d[i] = c - 0x30;
        }
        i++;
    }
    int ans = 0;
    int x = 1;
    for (i = i - 1; i >= 0; i--) {
        ans += d[i] * x;
        x *= 16;
    }
    printf("%d\n", ans);
    return 0;
}
