#include <stdio.h>

int DAYS[13]={-1,31,28,31,30,31,30,31,31,30,31,30,31};

int isRun(int year);
int dayOfYear(int year, int month, int day);
void MonthDay(int year, int yearDay, int *pMonth, int *pDay);
void inputDate(int *pYear, int *pMonth, int *pDay);
void inputYearAndDays(int *pYear,int *pDays);
char menu();
void choice1();
void choice2();

int main(){
	char choice;
	while((choice=menu())!='3'){
		switch(choice){
			case '1':{
				choice1();
				break;
			}
			case '2':{
				choice2();
				break;
			}
			default:{
				printf("Input error!\n");
				break;
			}
		}
	}
	printf("Bye!\n");
	return 0;
}

void choice1(){
	int year,month,day;
	inputDate(&year,&month,&day);
	int days=dayOfYear(year,month,day);
	printf("Days of you want for the date is %d.\n",days);
}

void choice2(){
	int year,days;
	inputYearAndDays(&year,&days);
	int month,day;
	MonthDay(year, days, &month, &day);
	printf("Year: %d, Month: %d, Day: %d\n",year,month,day);
}

char menu(){
	printf("\n");
	printf("1. year/ month/ day -> yearDay\n");
	printf("2. yearDay -> year/ month/ day\n");
	printf("3. Exit\n");
	printf("Please enter your choice: ");
	char c;
	scanf(" %c",&c);
	return c;
}

int isRun(int year){
	return year % 4 == 0 && year % 100 || year % 400 == 0;
}

int dayOfYear(int year, int month, int day){
	int i;
	int res=0;
	for(i=1;i<month;i++){
		res+=DAYS[i];
	}
	res+=day;
	if(isRun(year) && month>2){
		res++;
	}
	return res;
}

//warning: modified global variable in this function
void MonthDay(int year, int yearDay, int *pMonth, int *pDay){
	int i=1;
	int cur=0;
	int curIsRun=isRun(year);
	if(curIsRun){
		DAYS[2]=29;
	}
	while(cur+DAYS[i]<yearDay){
		cur+=DAYS[i];
		i++;
	}
	*pMonth=i;
	*pDay=yearDay-cur;
	if(curIsRun){
		DAYS[2]=28;
	}
}

void inputDate(int *pYear, int *pMonth, int *pDay){
	printf("Year: ");
	scanf("%d",pYear);
	printf("Month: ");
	scanf("%d",pMonth);
	printf("Day: ");
	scanf("%d",pDay);
}

void inputYearAndDays(int *pYear,int *pDays){
	printf("Year: ");
	scanf("%d",pYear);
	printf("Days you want to in this year: ");
	scanf("%d",pDays);
}
