#include <stdio.h>

typedef long long LL;

LL rapidIteration(int a,LL b,int m){
	LL ans=1;
	while(b>0){
		if(b&1){
			ans=ans * a % m;
		}
		a=a * a % m;
		b>>=1;
	}
	return ans;
}

LL rapidPow(int a,LL b,int m){
	if(b==0){
		return 1;
	}
	if(b & 1){
		return a * rapidPow(a,b-1,m) % m;
	}else{
		LL mul = rapidPow(a,b/2,m);
		return mul * mul % m;
	}
}

int main(){
	int a,m;
	LL b;
	scanf("%d %lld %d",&a,&b,&m);
	LL ans = rapidPow(a,b,m);
	printf("%lld\n",ans);
	return 0;
}
