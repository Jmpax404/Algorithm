#include <stdio.h>
#include <math.h>

#define N 200000

int isPrime(int x){
	int i;
	int end=sqrt(x);
	for(i=2;i<x;i++){
		if(x%i==0){
			return 0;
		}
	}
	return 1;
}

void print1898(int a[],int n,int ns[]){
	int c=1;//no
	int t=0;//total
	int s=0;//start
	int i;
	while(i<n){
		while(i<n && t<1898){
			t+=a[i];
			i++;
		}
		if(t==1898){
			printf("(%d).%3d,......,%d\n",c,ns[s],ns[i]);
			c++;
		}
		t-=a[s];
		s++;
	}
	while(t>1898 && s<n){
		t-=a[s];
		s++;
	}
	if(t==1898){
		printf("(%d).%3d,......,%d\n",c,ns[s],ns[i]);
	}
}

void work(){
	int ns[N];
	int n=0;
	int i;
	int bs[N];
	for(i=2;i<=N;i++){
		if(isPrime(i)){
			ns[n++]=i;
		}
	}
	for(i=0;i<n-1;i++){
		bs[i] = ns[i+1] - ns[i];
	}
	print1898(bs,n-1,ns);
}

int main(){
	printf("There are following primes in first row: \n");
	work();
	return 0;
}
