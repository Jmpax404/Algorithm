#include <stdio.h>

int howold(int no){
 	if(no==1) return 10;
 	return 2+howold(no-1);
}

int main(){
	printf("%d\n",howold(5));
	return 0;
}
