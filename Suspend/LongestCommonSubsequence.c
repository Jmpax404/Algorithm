// GIVE UP
#include <stdio.h>
#include <math.h>

char s1[5002],s2[5002];
int dp[5001][5001];//dp[0][j], dp[i][0] must be 0.

int main(){
	gets(s1);
	gets(s2);
	char *p1,*p2,c1,c2;
	int i,j;
	for(p1=s1,i=1;(c1=*p1)!='\0';p1++,i++)
		for(p2=s2,j=1;(c2=*p2)!='\0';p2++,j++)
			dp[i][j] = (c1==c2 ? dp[i-1][j-1]+1 : (int)fmax(dp[i-1][j],dp[i][j-1]) );
	int n=dp[i-1][j-1];
	printf(">>%d %d\n",i,j);
	int x1,x2=0;
	printf("  ");
	for(x1=0;x1<i;x1++){
		printf("%c ",s1[x1]);
	}
	printf("\n");
	for(x1=0;x1<i;x1++){
		printf("%c ",s2[x2]);
		for(x2=0;x2<j;x2++){
			printf("%d ",dp[x1][x2]);
		}
		printf("\n");
	}
	
	
	char ans[n];
	int ni=n-1;
	i--,j--;
	while(i>0&&j>0){
		int k=dp[i-1][j];
		int isJ=0;
		if(dp[i-1][j]<dp[i][j-1]){
			k=dp[i][j-1];
			
			isJ=1;
		}
		if(k!=dp[i][j]){
			ans[ni]=s1[i];
			printf("%c,%d %d\n",s1[i],i,j);
			i--,j--;
		}else{
			if(isJ){
				j--;
			}else{
				i--;
			}
		}
	}
	for(ni=0;ni<n;ni++){
		printf("%c",ans[ni]);
	}
	return 0;
}
