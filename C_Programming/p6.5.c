#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
	#define QUESTIONS_COUNT 10
	#define MARK_PER_QUESTION 10
	srand(time(NULL));
	int a,b,op;
	int i,passCount;
	double ans,resp,passRate;
	do{
		passCount=0;
		for (i=0;i<QUESTIONS_COUNT;i++){
			a=rand()%10+1;
			b=rand()%10+1;
			op=rand()%4;
			switch(op){
				case 0:
					ans=a+b;
					printf("%d + %d = ?\n",a,b);
					break;
				case 1:
					ans=a-b;
					printf("%d - %d = ?\n",a,b);
					break;
				case 2:
					ans=a*b;
					printf("%d * %d = ?\n",a,b);
					break;
				case 3:
					while( a/b != (ans=(double)a/b) ){
						a=rand()%10+1;
						b=rand()%10+1;
					}
					printf("%d / %d = ?\n",a,b);
					break;
			}
			if (scanf("%lf",&resp)!=1){
				while(getchar()!='\n');
			}
			if(resp==ans){
				switch(rand()%4+1){
					case 1:
						printf("Very good!\n");
						break;
					case 2:
						printf("Excellent!\n");
						break;
					case 3:
						printf("Nice work!\n");
						break;
					case 4:
						printf("Keep up the good work!\n");
						break;
				}
				passCount+=1;
			}else{
				switch(rand()%4+1){
					case 1:
						printf("No. Please try again!\n");
						break;
					case 2:
						printf("Wrong. Try once more!\n");
						break;
					case 3:
						printf("Don't give up!\n");
						break;
					case 4:
						printf("Not correct. Keep trying.\n");
						break;
				}
			}
		}
		printf("Your mark is %d\n",passCount*MARK_PER_QUESTION);
		passRate=passCount * 100.0 / QUESTIONS_COUNT;
		printf("Correct rate: %.2lf%%\n",passRate);
		if(passRate<=75){
			printf("Because your pass rate is not higher than 75%%, you need to answer again.\n");
		}
	}while(passRate<=75);
	return 0;
}



////test 1, 2 
//	srand(time(NULL));
//	int a,b;
//	while(1){
//		a=rand()%10+1;
//		b=rand()%10+1;
//		printf("%d * %d = ?\n",a,b);
//		int ans, wrongTimes=0;
//		do{
//			scanf("%d",&ans);
//			if(ans==a*b){
//				printf("Right!\n");
//				break;
//			}else{
//				wrongTimes++;
//				if(wrongTimes<3){
//					printf("Wrong! Please try again.\n");
//					printf("%d * %d = ?\n",a,b);
//				}else{
//					printf("Wrong! You have tried three times! Test over!\n");
//					return 0;
//				}
//			}
//		}while(1);
//	}
