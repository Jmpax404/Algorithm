#include <stdio.h>
#include <math.h>

main(){
	int x;
	scanf("%d",&x);
	x=abs(x);
	int ans=0;
	ans+=x%10*100;
	x/=10;
	ans+=x%10*10;
	x/=10;
	ans+=x%10;
	printf("%d\n",ans);
}
