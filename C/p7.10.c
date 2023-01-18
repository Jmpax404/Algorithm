#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
	srand(time(NULL));
	int num = rand() % (999-100+1)+100;
	printf("The number I choose secretly is %d.\n",num);
	int c=num % 10;
	int b=num /10 % 10;
	int a=num /100 % 10;
	int cal = (a+2*b+2*c)*100+(2*a+b+2*c)*10+(2*a+2*b+c);
	printf("The number I calculate is %d.\n",cal);
	//guess
	int i,j,k; 
	for(i=1;i<=9;i++){
		for (j=0;j<=9;j++){
			for (k=0;k<=9;k++){
				if ((i+2*j+2*k)*100+(2*i+j+2*k)*10+(2*i+2*j+k)==cal){
					printf("He can guess. %d\n",cal);
					break;
				}
			}
		}
	}
	return 0;
}
