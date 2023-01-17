#include <stdio.h>

unsigned long Fact(unsigned int n){
	unsigned int i;
	unsigned long result=1;
	for(i=2;i<=n;i++){
		result *= i;
	}
	return result;
}

int main(){
//	int n;
//	scanf("%d",&n);
//	int i;
//	for(i=1;i<=n;i++){
//		printf("%d: %lu\n",i,Fact(i));
//	}
//	return 0;
	int n;
	scanf("%d",&n);
	int i;
	long long res=0;
	for(i=1;i<=n;i++){
		res+=Fact(i);
	}
	printf("%ld\n",res);
	return 0;
}
