#include <stdio.h>
#include <string.h>

const char data[][16]={
	"Sunday",
	"Monday",
	"Tuesday",
	"Wednesday",
	"Thursday",
	"Friday",
	"Saturday"
};
int dn=7;

int main(){
	char s[16];
	gets(s);
	int i;
	int index = -1;
	for(i=0;i<dn;i++){
		if(strcmp(s,data[i])==0){
			index=i;
			break;
		}
	}
	if(index==-1){
		printf("Can not find.\n");
	}else{
		printf("%d\n",index);
	}
	return 0;
}
