#include <stdio.h>

int myMax(int a, int b){
	return a>b ? a : b;
}

void myScanf(const char info[], int *val){
	printf("%s",info);
	int c = scanf("%d",val);
	while(c!=1){
		while(getchar()!='\n');
		printf("%s",info);
		c = scanf("%d",val);
	}
}

int main(){
	int x, y;
	myScanf("a: ",&x);
	myScanf("b: ",&y);
	int max = myMax(x,y);
	printf("%d\n",max);
	return 0;
}
