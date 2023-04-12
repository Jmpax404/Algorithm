#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_VALUE 30

int playerChoose(int cur){
	char c;
	int num;
	printf("enter y to choose two figures(or you will choose only one figure):");
	while(scanf(" %c",&c)!=1){
		while(getchar()!='\n');
	}
	if(cur+2>MAX_VALUE) return cur+1;
	if(c=='y') 			return cur+2;
	else 				return cur+1;
}

int computerChoose(int cur){
	int i;
	for(i=0;i<1e9;i++);//"thinking"
	int leave = MAX_VALUE - cur;
	switch(leave % 3){
		case 1:
			return cur+1;
		case 2:
			return cur+2;
		default:{
			if(rand() % 2) cur++;
			return cur+1;
		}
	}
	return cur;
}

void printfChoose(int cur,int now){
	if(now-cur>1) printf("%d, %d\n",now-1,now);
	else printf("%d\n",now);
}

int main(){
	srand(time(NULL));
	int turn = rand() % 2;
	int curNum=0,nowNum;
	while(1){
		if(turn){
			printf("PLAYER CHOOSE:\n");
			nowNum = playerChoose(curNum);
			turn=0;
		}else{
			printf("COMPUTER CHOOSE:\n");
			nowNum = computerChoose(curNum);
			turn=1;
		}
		printfChoose(curNum,nowNum);
		curNum=nowNum;
		if(curNum == MAX_VALUE) break;
	}
	if(turn) printf("Computer Win!\n");
	else printf("Player Win!\n");
	return 0; 
}
