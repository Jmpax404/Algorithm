#include <stdio.h>

int leastCommonMultiple(int a,int b);

int main(){
	int a,b;
	scanf("%d%d",&a,&b);
	printf("%d\n",leastCommonMultiple(a,b));
	return 0;
}

int leastCommonMultiple(int a,int b){
	if(a<b){//let b<a
		int t=a;
		a=b;
		b=t;
	}
	int i;
	for(i=1;i<a;i++){
		if(i * b % a == 0) return i*b;
	}
	return a*b;
}
