#include <stdio.h>

int readScore(int arr[]){
	int t;
	int i=0;
	do{
		printf("Enter a score: ");
		scanf("%d",&t);
		if(t>0){
			arr[i]=t;
			i++;	
		}
	}while(i<40 && t>0);
	return i;
}

double average(int arr[],int n){
	int i;
	int count=0;
	for(i=0;i<n;i++){
		count+=arr[i];
	}
	return (double)count / n;
}

int numberOverAverage(int arr[], int n, double aver){
	int i;
	int count=0;
	for(i=0;i<n;i++){
		if(arr[i]>aver){
			count++;
		}
	}
	return count;
}

int main(){
	int scores[40];
	int n=readScore(scores);
	double aver = average(scores,n);
	int count = numberOverAverage(scores,n,aver);
	printf("The number of the students' mark that is above the average is %d.\n",count);
	return 0;
}
