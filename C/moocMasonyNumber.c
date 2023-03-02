#include <stdio.h>
#include <math.h>

int main(){
	double d=1;
	int i,j;
	double t;
	for(i=1;i<=50;i++){
		d*=2;
		t=d-1;
		double end=sqrt(t);
		int isHe=0;
		for(j=2;j<end;j++){
			if(t/j==(int)(t/j)){
				isHe=1;
				break;
			}
		}
		if(!isHe){
			printf("2^%d-1=%lf\n",i,t);
		}
	}
	return 0;
}
