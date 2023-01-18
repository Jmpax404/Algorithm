#include <stdio.h>

int Gcd1(int a, int b){
	int t = a < b ? a : b;
	for(t; t>=1; t--){
		if (a%t == 0 && b%t == 0){
			return t;
		}
	}
	return 1;
}

int Gcd2(int a, int b){
	int r = a % b;
	while(r){
		a = b;
		b = r;
		r = a % b;
	}
	return b;
}

int Gcd3(int a, int b){
	while(a != b){
		if (a>b) a-=b;
		else if (a<b) b-=a;
	}
	return a;
}

int main(){
	int a,b;
	scanf("%d %d",&a,&b);
	printf("%d\n",Gcd3(a,b));
	return 0;
}
