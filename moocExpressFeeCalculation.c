#include <stdio.h>
#include <math.h>

int main(){
	int c;
	float w;
	scanf("%d,%f",&c,&w);
	if(c<0||c>4){
		printf("Error in Area\nPrice:  0.00\n");
		return 0;
	}
	if(w<=0){
		printf("Price:  0.00\n");
		return 0;
	}
	w=(float)ceil(w);	
	float fps[5]={10,10,15,15,15};
	float aps[5]={3,4,5,6.5,10};
	float total = fps[c];
	w-=1;
	if(w>0){
		total+=aps[c]*w;
	}
	printf("Price: %5.2f\n",total);
	return 0;
}
