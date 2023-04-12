#include <stdio.h>
#include <math.h>

main(){
	double capital;
	int n;
	scanf("%lf",&capital);
	scanf("%d",&n);
	printf("%lf\n", capital* pow(1+2.25/100,n));
} 


