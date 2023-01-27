#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 60000000

int main(){
	srand(time(NULL));
	int r;
	int arr[6]={0};
	int i;
	for(i=0;i<N;i++){
		arr[rand() % 6]++;
	}
	for(i=0;i<6;i++){
		printf("%d: %lf\n",i+1,arr[i]/(double)N);
	}
	return 0;
}
