#include <stdio.h>

#define STUDENTS_COUNT 40

void printStat(int arr[],int grades[],int n);


void printList(int arr[],int n){
	int grades[11]={0};
	int i,j,t;
	for(i=0;i<n;i++){
		grades[arr[i]]++;
	}
	printf("Grade\t\tCount\t\tHistogram\n");
	for(i=1;i<=10;i++){
		t=grades[i];
		printf("%3d\t\t%3d\t\t ",i,t);
		for(j=0;j<t;j++){
			printf("* ");
		}
		printf("\n");
	}
	printStat(arr,grades,n);
}

//warning: the order of this array will be changed.
double findMedian(int arr[],int n){
	int i,j,tMax,tIndex,t;
	for(i=n-1;i>=1;i--){
		tMax=-1;
		tIndex=-1;
		for(j=i;j>=0;j--){
			if(arr[j]>tMax){
				tMax=arr[j];
				tIndex=j;
			}
		}
		t=arr[i];
		arr[i]=tMax;
		arr[tIndex]=t;
	}
	t=n/2;
	if(t){
		return arr[t];
	}else{
		return (arr[t]+arr[t-1])/2.0;
	}
}


void printStat(int arr[],int grades[],int n){
	double mean=0.0;
	int modeCount=-1;
	int modeGrade=-1;
	int i,t;
	for(i=1;i<=10;i++){
		t=grades[i];
		mean+=i*t;
		if(t>modeCount){
			modeCount=t;
			modeGrade=i;
		}
	}
	mean = mean / STUDENTS_COUNT;
	double median=findMedian(arr,n);
	printf("Mean: %lf\n",mean);
	printf("Median: %lf\n",median);
	printf("Mode: %d\n",modeGrade);
}

int main(){
	int i;
	int feedback[STUDENTS_COUNT];
	for(i=0;i<STUDENTS_COUNT;i++){
		scanf("%d",&feedback[i]);
	}
	printList(feedback,i);
	return 0;
}
