#include <stdio.h>

#define N 128

void insertSpace(char *s){
	char st[N],c;
	char *stp=st;
	char *sorig=s;
	*stp++ = *s++;
	while((c=*s)!='\0'){
		*stp++='-';
		*stp++=c;
		s++;
	}
	*stp='\0';
	stp=st;
	while((c=*stp)!='\0'){
		*sorig++=c;
		stp++; 
	}
}

int main(){
	char s[N];
	//gets(s);
	fgets(s,sizeof(s),stdin);
	insertSpace(s);
	printf(">%s<\n",s);
	return 0;
}
