#include <stdio.h>

int main(){
	float h=100;
	int i,n;
	scanf("%d",&n);
	float total=h;
	h/=2;
	for(i=2;i<=n;i++){
		total+=h*2;
		h/=2;	
	}
	printf("%f %f",total,h);
	return 0;
}
