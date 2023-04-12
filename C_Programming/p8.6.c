#include <stdio.h>

typedef struct{
	int score;
	long id;
}Student;

int readScore(Student arr[]){
	int i=0;
	int score;
	long id;
	do{
		scanf("%d",&score);
		if(score>0){
			arr[i].score=score;
			scanf("%ld",&id);
			arr[i].id=id;
			i++;
		}
	}while(i<40 && score>0);
	return i;
}

int findMax(Student arr[],int n){
	int maxScore = -1;
	int maxPos=-1;
	int i;
	for(i=0;i<n;i++){
		if(arr[i].score>maxScore){
			maxScore = arr[i].score;
			maxPos=i;
		}
	}
	return maxPos;
}

int main(){
	Student students[40];
	int n =readScore(students);
	int index = findMax(students,n);
	printf("%d %ld\n",students[index].score,students[index].id); 
	return 0;
}
