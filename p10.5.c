#include <stdio.h>

//slow
void deleteChar(char s[],char c){
	int i,j;
	char t;
	for(i=0; (t=s[i]) != '\0'; i++){
		if(t==c){
			for(j=i+1;(t=s[j]) != '\0';j++){
				s[j-1]=s[j];
			}
			s[j-1]='\0';
		}
	}
}

int main(){
	char s[128],c;
	fgets(s,sizeof(s),stdin);
	scanf("%c",&c); 
	deleteChar(s,c);
	puts(s);
	return 0;
}
