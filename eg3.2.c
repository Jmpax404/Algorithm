#include <stdio.h>
#define PI 3.14159



main(){
	const double pi =3.14159;	
	double r;
	scanf("%lf",&r);
	printf("surface=%lf\n",4*PI*r*r);
	printf("volume=%lf\n",4*pi*r*r*r/3);
}
