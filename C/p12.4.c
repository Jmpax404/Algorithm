#include <stdio.h>
#include <string.h>

typedef struct {
	char name[8];
	int count;
} Candidate;

void toSupper(char *str){
	char c;
	for( ;(c = *str)!='\0';str++){
		if(c>='A' && c<='Z'){
			(*str)+=32;
		}
	}
}

int main(){
	Candidate candidates[3] = {
		{"zhang",0}, 
		{"li",0},
		{"wang",0},
	};
	int dropCount=0;
	int i,j;
	char s[8]; 
	int matched;
	for(i=0;i<10;i++){
		scanf("%s",s);
		toSupper(s);
		matched=0;
		for(j=0;j<3;j++){
			if(strcmp(candidates[j].name,s)==0){
				matched=1;
				candidates[j].count++;
				break;
			}
		}
		if(!matched){
			dropCount++;
		}
	}
	//print
	for(j=0;j<3;j++){
		printf("%s: %d\n",candidates[j].name,candidates[j].count);
	}
	printf("%s: %d\n","Drop: ",dropCount);
	return;
}
