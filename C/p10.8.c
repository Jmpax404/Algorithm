#include <stdio.h>

void myStrcat(char *dst, const char *src){
	while(*dst!='\0'){ dst++; }
	while(*src!='\0'){ *dst++ = *src++; }
	*dst='\0';
}

int main(){
	char s1[64];
	char s2[64];
	gets(s1);
	gets(s2);
	myStrcat(s1,s2);
	puts(s1);
	return 0;
}
