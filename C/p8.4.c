#include <stdio.h>

int main(){
	int arr[40],n;
	scanf("%d",&n);
	if(n>40){
		printf("Maximum number of people is 40.\n");
		return 0;
	}
	int count = 0;
	int i, t;
	for(i=0;i<n;i++){
		scanf("%d",&t);
		if (t<60){
			count++;
		}
	}
	printf("The number of students failed is %d.\n",count);
	return 0;
}
