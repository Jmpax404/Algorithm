#include <stdio.h>
#include <string.h>

/**
 * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
 *
 * 
 * @param A string�ַ��� 
 * @return int����
 */
int getLongestPalindrome(char* A ) {
    int L = strlen(A);
    if (L==1) return 1;
    int dp[L][L];
    memset(dp,0,sizeof(dp));
    int i,j,maxl=1;
    dp[0][0]=1;//boarder
    for(i=1;i<L;i++){
    	dp[i][i]=1;
    	if(A[i-1]==A[i]){
    		dp[i-1][i]=1;
    		maxl=2;
		}
	}
	for(i=2;i<=L-1;i++){//dp
		for(j=0;j+i<L;j++){
			if(A[j]==A[j+i]){
				int k=dp[j+1][j+i-1];
				dp[j][j+i]=k;
				if(k==1) maxl=i+1;
			}
		}
	}
    return maxl;
}

int main(){
	char s[1002];
	scanf("%s",&s);
	printf("%d\n",getLongestPalindrome(s));
	return 0;
}
