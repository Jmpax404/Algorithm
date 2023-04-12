#include <stdio.h>

double func(double x){
	return x*x*x-x-1;
}

int main(){
	const double EPS = 1e-6;
	double l=0,r=4;
	double m,mv;
	while(l<=r){
		m=(l+r)/2;
		mv=func(m);
		if(fabs(mv)<=EPS){
			break;
		}
		if(func(l)*mv<0){
			r=m-EPS;
		}else{
			l=m+EPS;
		}
	}
	printf("x=%6.2lf\n",m);
	return 0; 
}
