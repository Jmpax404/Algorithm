#include <stdio.h>

int main(){
    int n, arr[10000],dp[10000];
    while(~scanf("%d",&n)){
        int maxLen=1,i,j;
        scanf("%d",&arr[0]);
        dp[0]=1;
        for(i=1;i<n;i++){
            scanf("%d",&arr[i]);
            int curMaxLen=1;
            for(j=i-1;j>=0;j--){
            	//must be > , but not be >=
                if(arr[i]>arr[j] && dp[j]+1>curMaxLen){
                    curMaxLen=dp[j]+1;
                }
            }
            dp[i]=curMaxLen;
            if (curMaxLen>maxLen) maxLen=curMaxLen;
        }
        printf("%d\n",maxLen);
    }
    return 0;
}
