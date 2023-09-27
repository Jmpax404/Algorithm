#include <stdio.h>

void handle(int arr[],int c){//c(4<c<80)
	bool isFirst=true;
	if(arr[0]!=arr[1]){
		isFirst=false;
		printf("0");
	}
	for(int i=1;i<c-1;i++){
		if( (arr[i]>arr[i-1] && arr[i]>arr[i+1]) || (arr[i]<arr[i-1] && arr[i]<arr[i+1]) ){
			if(isFirst){
				printf("%d",i);	
				isFirst=false;
			}
			printf(" %d",i);
		}
	}
	if(arr[c-2]!=arr[c-1]){
		if(!isFirst){
			printf(" ");
		}
		printf("%d",c-1);
	}
	printf("\n");
}

int main(){
	int n;
	int c;
	int arr[90];
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&c);
		for(int j=0;j<c;j++){
			scanf("%d",&arr[j]);
		}
		handle(arr,c); 
	}
	return 0;
}
