#include <stdio.h>

int main(){
	double w,h,t;
	printf("w: ");	scanf("%lf",&w); 
	printf("h: ");	scanf("%lf",&h);
	t=w/(h*h);
	printf("%lf\n",t);
	if (t>=27) 		printf("·ÊÅÖ\n");
	else if (t>=25) printf("³¬ÖØ\n");
	else if (t>=18) printf("Õý³£\n");
	else  			printf("µÍ\n");
	return 0;
}
