#include <stdio.h>
#include <math.h>

main(){
	double a,b,c;
	scanf("%lf %lf %lf",&a,&b,&c);
	double t=sqrt(b*b-4*a*c);
	double x1=(-b-t)/(2*a);
	double x2=(-b+t)/(2*a);
	printf("%lf,%lf",x1,x2);
}
