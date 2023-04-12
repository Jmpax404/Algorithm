#include <stdio.h>
#include <string.h>

#define L 16
#define N 5

int compare(const char *s1, const char *s2){
	for( ; *s1==*s2; s1++, s2++){
		if(*s1=='\0'){ return 0; }
	}
	return *s1 - *s2;
}

void move(char *dst, const char *src){
	strcpy(dst,src);
}

void sort(char arr[][L], int n, int (*cmp)(const char *s1, const char *s2)){
	int i,j,k;
	char s[L];
	for(i=1;i<n;i++){
		move(s,arr[i]);
		for(j=i-1; j>=0 && cmp(s,arr[j]) < 0 ; j-- );
		for(k=i-1;k>j;k--){
			move(arr[k+1],arr[k]);			
		}
		move(arr[j+1],s);
	}
}

int main(){
	char countries[N][L];
	int i;
	for(i=0;i<N;i++){
		gets(countries[i]);
	}
	sort(countries,N,compare);
	printf("\n");
	for(i=0;i<N;i++){
		puts(countries[i]);
	}
	return 0;	
}
