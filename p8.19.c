#include <stdio.h> 
#include <stdlib.h>
#include <time.h>
#include <math.h>

#define MAX_N 1024
#define MAX_M 64

int main();

int getAthleteCount();
int getJudgeCount();
void startGame(int data[MAX_N][MAX_M],int n,int m);
int generateScore();
void statAthlete(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N]);
void statJudge(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N]);

void sortAverScore(double avers[],int sortedIndexs[],double sortedAvers[],int n);
void getAverScore(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N]);
void printAverScore(int sortedIndexs[MAX_N],double sortedAvers[MAX_N],int n);
void getJudgeScores(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N],double judgeScores[MAX_M]);
void printJudgeScore(int sortedIndexs[MAX_N],double sortedAvers[MAX_N],int n);

int getAthleteCount(){
	int n;
	printf("Athlete Count: ");
	while(scanf("%d",&n)!=1 || n<1){
		while(getchar()!='\n');
		printf("The number of the athlete is at least 1\n");
		printf("Athlete Count: ");
	}
	printf("[you input] Athlete Count: %d\n",n);
	return n;
}

int getJudgeCount(){
	int n;
	printf("Judge Count: ");
	while(scanf("%d",&n)!=1 || n<=2){
		while(getchar()!='\n');
		printf("The number of the judge is at least 3\n");
		printf("Judge Count: ");
	}
	printf("[you input] Judge Count: %d\n",n);
	return n;
}

int generateScore(){
	{ int i; for(i=0;i<1e8;i++); }
	return rand() % 11;
}

void getAverScore(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N]){
	int i,j,t;
	int total,maxScore,minScore;
	double aver;
	for(i=0;i<n;i++){
		total=0;
		maxScore=-1;
		minScore=11;
		for(j=0;j<m;j++){
			t=data[i][j];
			if(t>maxScore){
				maxScore=t;
			}
			if(t<minScore){
				minScore=t;
			}
			total+=t;
		}
		total-=maxScore;
		total-=minScore; 
		aver = total / (m-2.0);
		avers[i]=aver;
	}
}

void sortAverScore(double avers[],int sortedIndexs[],double sortedAvers[],int n){
	int i,j,k,ti;
	double t;
	for(i=0;i<n;i++){ sortedIndexs[i]=i; }
	for(i=0;i<n;i++){ sortedAvers[i]=avers[i]; }
	for(i=1;i<n;i++){
		t=sortedAvers[i];
		ti=sortedIndexs[i];
		for(j=i-1;j>=0 && sortedAvers[j]>t;j--);
		for(k=i-1;k>j;k--){
			sortedAvers[k+1]=sortedAvers[k];
			sortedIndexs[k+1]=sortedIndexs[k];
		}
		sortedAvers[j+1]=t;
		sortedIndexs[j+1]=ti;
	}
}

void printAverScore(int sortedIndexs[MAX_N],double sortedAvers[MAX_N],int n){
	int i,j;
	printf("Order of Athletes:\n");
	printf("order\tfinal score\tnumber code\n");
	for(i=0;i<n;i++){
		printf("%5d\t%11.2lf\t%10d\n",i+1,sortedAvers[i],sortedIndexs[i]);
	}
	printf("\n");
}

void printJudgeScore(int sortedIndexs[MAX_N],double sortedAvers[MAX_N],int n){
	int i,j;
	printf("Order of Judges:\n");
	printf("judge\tfinal score\tnumber code\n");
	for(i=0;i<n;i++){
		printf("%5d\t%11.2lf\t%10d\n",i+1,sortedAvers[i],sortedIndexs[i]);
	}
	printf("\n");
}

void getJudgeScores(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N],
					double judgeScores[MAX_M]){
	int i,j,k,t;
	double sum;
	for(j=0;j<m;j++){
		sum=0.0;
		for(i=0;i<n;i++){
			sum+=pow(data[i][j]-avers[i],2);
		}
		judgeScores[j]=10-sqrt(sum/n);
	}	
}

void startGame(int data[MAX_N][MAX_M],int n,int m){
	int i,j,t;
	for(i=0;i<n;i++){
		printf("Athlete %d is playing..\n",i);
		for(j=0;j<m;j++){
			t=generateScore();
			data[i][j]=t;
			printf("Judge %d gives score: %d\n",j,t);
		}
		printf("\n");
	}
}

void statAthlete(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N]){
	int sortedIndexs[MAX_N];
	double sortedAvers[MAX_N];
	getAverScore(data,n,m,avers);
	sortAverScore(avers,sortedIndexs,sortedAvers,n);
	printAverScore(sortedIndexs,sortedAvers,n);
}

void statJudge(int data[MAX_N][MAX_M],int n,int m,double avers[MAX_N]){
	double judgeScores[MAX_M];
	double sortedJudgeIndexs[MAX_M],sortedJudgeAvers[MAX_M];
	getJudgeScores(data, n, m, avers, judgeScores);
	sortAverScore(judgeScores,sortedJudgeIndexs,sortedJudgeAvers,m);
	printJudgeScore(sortedJudgeIndexs,sortedJudgeAvers,m);
}

int main(){
	srand(time(NULL));
	int n=getAthleteCount();
	int m=getJudgeCount();
	int data[MAX_N][MAX_M];
	double avers[MAX_N];
	startGame(data,n,m);
	statAthlete(data,n,m,avers);
	statJudge(data,n,m,avers);
	return 0;
}
