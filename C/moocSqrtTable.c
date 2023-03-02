#include <stdio.h>
#include <math.h>

void printTable(int n){
	int i,j,k=0;
	printf(" ");
	for(i=0;i<n;i++){
		printf("%7d",i);
	}
	printf("\n");
	for(i=0;i<n;i++){
		printf("%d",i);
		for(j=0;j<n;j++){
			printf("%7.3f",(float)sqrt(k));
			k++;
		}
		printf("\n");
	}
}

int main(){
	printf("Input n(n<=10):\n");
	int n;
	scanf("%d",&n);
	printTable(n);
	return 0; 
}
