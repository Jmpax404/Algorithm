#include <stdio.h>
#include <string.h>

char *reverse(char *s){
	int n = strlen(s);
	int i;
	int end = n / 2;
	char t;
	for(i=0;i<end;i++){
		t=s[i];
		s[i]=s[n-i-1];
		s[n-i-1]=t;
	}
	return s;
}

int main(){
	char s[64];
	gets(s);
	puts(reverse(s));
	return 0;
}
