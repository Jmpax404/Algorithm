#include <cstdio>

int main(){
	int n;
	while(scanf("%d",&n)!=EOF){
		int a[10001]={0};
		int b[n];
		for(int i=0;i<n;i++){
			scanf("%d",&b[i]);
			a[b[i]]++;
		}
		bool f=false; 
		for(int i=0;i<n;i++){
			if(a[b[i]]==1){
				printf("%d\n",b[i]);
				f=true;
				break;
			}
		}
		if(!f){
			printf("None\n");
		}
	}
	return 0;
}
