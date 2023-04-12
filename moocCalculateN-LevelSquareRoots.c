#include <stdio.h>
#include <math.h> 
double func(double x, int n){
	if(n==0) { return 0; }
	return sqrt(x+func(x,n-1));
}


int main(){
	printf("%.2lf\n",func(16,0));
	
	return 0;
}
