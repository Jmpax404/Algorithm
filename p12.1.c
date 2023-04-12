#include <stdio.h>

int main(){
	int i;
	int h,m,s;
	int t;
	int end=24*60*60;
	for(;;){
		for(i=0;i<end;i++){
			t=i;
			h = t/3600;
			t -= h*3600;
			m = t/60;
			t -= m*60;
			s=t;
			printf("\r%02d:%02d:%02d",h,m,s);
		}		
	}
}

//12.2
//typedef struct {
//	int hour;
//	int minute;
//	int second;
//}Clock;
//
//void delay(){
//	int i;
//	for(i=0;i<1e5;i++);
//}
//
//void update(Clock *clock){
//	int s=clock->second;
//	int m=clock->minute;
//	int h=clock->hour;
//	s++;
//	if(s>=60){
//		s=0;
//		m++;
//	}
//	if(m>=60){
//		m=0;
//		h++;
//	}
//	if(h>=24){
//		h=0;
//	}
//	clock->hour=h;
//	clock->minute=m;
//	clock->second=s;
//}
//
//void show(Clock clock){
//	printf("\r%02d:%02d:%02d",
//		clock.hour,
//		clock.minute,
//		clock.second
//	);
//}
//
//int main(){
//	Clock c = {0,0,0};
//	for(;;){
//		show(c);
//		delay();
//		update(&c);
//	}
//	return 0;
//}



//12.1
//typedef struct {
//	int year;
//	int month;
//	int day;
//}Birth;
//
//typedef struct {
//	int college;
//	int title;
//	int subject;	
//}Status;
//
//typedef struct {
//	Birth birth;
//	Status status;
//	char name[10];
//	char sex;
//}Employee;
