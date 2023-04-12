#include <stdio.h>
#include <algorithm>

using namespace std;

int main(){
	int c;
	scanf("%d",&c);
	int n,v,w;
	int p[110]={0};
	for(int i=0;i<c;i++){
		scanf("%d%d%d",&n,&v,&w);
		for(int j=0;j<n;j++){
			scanf("%d",&p[j]);
		}
		sort(p,p+n);
		int count=0;
		double ans = 0.0;
		while(count < n && p[count]<=w){
			ans+=p[count];
			count++;
		}
		if(count != 0){//warning: division by 0
			ans/=count;	
		}
		double t;
		for(int j=count;j<n;j++){
			t=(ans*count+p[j]) / (count + 1);
			if(t<=w){
				ans=t;
				count++;
			}else{
				break;
			}
		}
		printf("%d %.2lf\n",count*v, ans/100);//warning: anwser without %
	}
	return 0;
}
