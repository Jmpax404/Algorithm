#include <stdio.h>
#include <string.h>

void myType(char *s){
	s[strlen(s)-1]='\0';
	FILE *fp;
	if((fp=fopen(s,"r"))==NULL){
		printf("[ERROR] The file doesn't exist.\n");
		return;
	}
	char c;
	while((c=fgetc(fp)) != EOF){
		printf("%c",c);
	}
}

int main(){
	printf("type ");
	char s[64];
	fgets(s,sizeof(s),stdin);
	myType(s);
	return 0;
}
