#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int inputTimes(){
	int n;
	printf("Times to try: ");
	while(scanf("%d",&n)!=1 || n<=0){
		printf("You should input a positive integer.\n");
		while(getchar()!='\n');
		printf("Times to try: ");
	}
	return n;
}

int inputVal(){
	int n;
	printf("enter the number of 4 digits you guess: ");
	while(scanf("%d",&n)!=1 || n<1000 || n>9999){//TODO: 4 digits should be different.
		printf("You should input a 4 digits number.\n");
		while(getchar()!='\n');
		printf("enter the number of 4 digits you guess: ");
	}
	return n;
}

void generateNumber(int arr[]){
	int set[10]={0};
	int i,t;
	do{
		t=rand()%10;
	}while(t==0);
	arr[0]=t;
	set[t]++;
	for(i=1;i<4;i++){
		t=rand()%10;
		if(!set[t]){
			arr[i]=t;
			set[t]++;
		}else{
			i--;
		}
	}

}

void giveInfo(int arr[4],int val){
	int vals[4];
	int i,t,j;
	for(i=3;i>=0;i--){
		vals[i]=val % 10;
		val/=10;	
	}
	int ca=0;
	int cb=0;
	for(i=0;i<4;i++){
		t=arr[i];
		for(j=0;j<4;j++){
			if(t==vals[j]){
				if(i==j){
					ca++;
				}else{
					cb++;
				}
				break;
			}
		}
	}
	printf("INFO: %dA%dB\n",ca,cb);
}

void printAns(int arr[4]){
	printf("Sorry, you haven't guessed the right number!\n");
	printf("The number is:");
	int i;
	for(i=0;i<4;i++){
		printf(" %d",arr[i]);
	}
	printf("\n");
}

int main(){
	srand(time(NULL));
	int n = inputTimes();
	int arr[4];
	generateNumber(arr);
	int t,i;
	int isBingo=0;
	for(i=0;i<n;i++){
		t = inputVal();
		if(arr[0]*1000+arr[1]*100+arr[2]*10+arr[3] == t){
			printf("Congratulations!\n");
			isBingo=1;
			break;
		}
		else{
			giveInfo(arr,t);	
		}
	}
	if(!isBingo){
		printAns(arr);
	}
	return 0;
}
