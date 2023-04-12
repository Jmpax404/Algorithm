#include <stdio.h>
#include <string.h> 

int main(){
	char s1[64],s2[64];
	scanf("%s%s",s1,s2);
	int l1=strlen(s1);
	int l2=strlen(s2);
	int i,j,k,t;
	for(i=l2-1;i>=0;i--){
		if(s2[i]==s1[l1-1]){
			j=l1-1-1;
			k=i-1;
			while(j>=0 && k>=0 && s1[j]==s2[k]){
				j--;
				k--;
			}
			if(k==-1){
				for(t=0;t<=i;t++){
					printf("%c",s2[t]);
				}
				printf("\n");
				break;
			}
		}
	}
	return 0;
}
