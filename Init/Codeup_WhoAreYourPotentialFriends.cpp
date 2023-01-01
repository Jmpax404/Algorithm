#include <cstdio>

int main(){
	int n,m;
	while(scanf("%d%d",&n,&m)!=EOF){
		int rs[n+1],bs[m+1]={0}; 
		int k;
		for(int i=0;i<n;i++){
			scanf("%d",&k);
			rs[i]=k;
			bs[k]++;
		}
		for(int i=0;i<n;i++){
			k=bs[rs[i]];//common readers 
			if(k<=1){
				printf("BeiJu\n");
			}else{
				printf("%d\n",k-1);
			}
		}
	}
	return 0;
}
