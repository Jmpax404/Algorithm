#include <stdio.h>

int main(){
	char c;
	if((c = getchar()=='\n')){
		printf("Count: %d\n",0);
		return 0;
	}
	int count=1;
	while((c = getchar())!='\n'){
		if(c==' '){
			count++;
		}
	}
	printf("Count: %d\n",count);
	return 0;
}

