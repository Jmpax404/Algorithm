#include <stdio.h>

int main(){
	int b,w,r;
	int t=0;
	printf("The result:\n");
	for(r=1;r<=3;r++){
		for(w=1;w<=5;w++){
			for(b=0;b<=6;b++){
				if(b+r+w==8){
					printf("red:%4d white:%4d black:%4d\n",r,w,b);
					t++;
				}
			}
		}
	}
	printf("sum=%4d\n",t);
	return 0;
}
