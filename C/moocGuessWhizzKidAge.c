#include <stdio.h>
#include <string.h>
int main(){
	int i;
	for(i=10;i<=22;i++){
		int v3=i*i*i;
		int v4=v3*i;
		printf("%d %d\n",v3,v4);
		if(v4/100000<=0){ continue; }
		int arr[10];
		memset(arr,0,sizeof(arr));
		while(v3>0){
			arr[v3%10]++;
			v3/=10;	
		}
		while(v4>0){
			arr[v4%10]++;
			v4/=10;
		}
		int j, correctFlag=1;
		for(j=0;j<10;j++){
			if (arr[j]>1){
				correctFlag=0;
				break;
			}
		}
		if(correctFlag){
			printf("age=%d\n",i);
			break;
		}
	}
	return 0;
}
