#include <stdio.h>

int main(){
	double w,h,t;
	printf("w: ");	scanf("%lf",&w); 
	printf("h: ");	scanf("%lf",&h);
	t=w/(h*h);
	printf("%lf\n",t);
	if (t>=27) 		printf("����\n");
	else if (t>=25) printf("����\n");
	else if (t>=18) printf("����\n");
	else  			printf("��\n");
	return 0;
}
