#include <cstdio>

int main(){
	int n;
	while(~scanf("%d",&n)){
		int ans=0;
		for(int i=1;i<=n;i++){
			bool is7=false;
			int it=i;
			if(i%7==0){
				is7=true;
			}else{
				while(it>0){
					if(it%10==7){
						is7=true;
						break;
					}
					it/=10;
				}
			}
			if(!is7){
				ans += i*i;	
			}
		}
		printf("%d\n",ans);
	}
	return 0;
}
