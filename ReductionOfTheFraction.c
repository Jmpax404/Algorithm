#include <stdio.h>

int gcd1(int a,int b){
	int t;
	if(a<b){
		t=a,a=b,b=t;
	}
	int c; 
	while(b){
		c=a%b;
		a=b;
		b=c;	
	}
	return a;
}

int gcd(int a, int b){
	while(a!=b){
		if(a>b){
			a=a-b;
		}else{
			b=b-a;
		}
	}
	return a;
}

int main(){
	int a,b,c;
	scanf("%d %d",&a,&b);
	while((c=gcd(a,b))!=1){
		a/=c;
		b/=c;
	}
	printf("%d/%d\n",a,b);
	return 0;
}
