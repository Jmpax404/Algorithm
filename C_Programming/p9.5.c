#include <stdio.h>

float integral(float (*f)(float),float a,float b){
	float piece = (b - a) / 1e6;
	float i;
	float res=0.0; 
	for(i=a;i<b;i+=piece){
		res+=(*f)(i) * piece;
	}
	return res;
}

int main(){
	float func1(float x){ return 1+x*x; }
	float func2(float x){ return x/(1+x*x); }
	printf("%f\n",integral(func1,0,1));
	printf("%f\n",integral(func2,0,3));
	return 0;
}
