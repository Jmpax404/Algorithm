#include <stdio.h>
#include <string.h>

#define N 100

int Inverse(char str1[],char str2[][N]){
	int n=strlen(str1);
	int i;
	char c;
	int j=0,k=0;
	for(i=0;i<n-1;i++){
		c=str1[i];
		if(c!=' '){
			str2[j][k]=c;
			k++;
		}else{
			str2[j][k]='\0';
			k=0;
			j++;
		}
	}
	j++;
	int n2=strlen(str2[0]);
	str2[0][n2]=str1[n-1];
	str2[0][n2+1]='\0';
	return j;
}

int main(){
	printf("Input a sentence: ");
	char s[N];
	gets(s);
	char s2[N][N];
	int n = Inverse(s,s2);
	int i;
	printf("%s",s2[n-1]);
	for(i=n-2;i>=0;i--){
		printf(" %s",s2[i]);
	}
	return 0;
}
