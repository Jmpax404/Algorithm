#include <stdio.h>

int Strlen(char s[]);

void Insert(char s[]);

int main(){
	char s[80];
	printf("Input a string:\n");
	gets(s);
	Insert(s);
	printf("Insert result:\n");
	return 0;
}

int Strlen(char s[]){
	int n=0;
	while(s[n]!='\0'){ n++; }
	return n;
}

void Insert(char s[]){
	int n,i;
	n=Strlen(s);
	if(n==0){ return; }
	for(i=n-1;i>=1;i--){
		s[i*2]=s[i];
		s[i*2-1]=' ';
	}
	s[n*2-1]='\0';
}
