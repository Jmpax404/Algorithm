#include <stdio.h>

main(){

}

//5.10
//	int y,m;
//	printf("Please enter year and month divided by a space:");
//	scanf("%d %d",&y,&m);
//	if (m<1||m>12){
//		printf("Month should be from 1 to 12.");
//		return;
//	}
//	int isr = (  (y%4==0 && y%100) || (y%400==0)     );
//	int ms[13]={-1,31,28,31,30,31,30,31,31,30,31,30,31};
//	if (m==2 && isr) ms[2]++;
//	printf("%d\n",ms[m]);



//5.9
//	float f;
//	scanf("%f",&f);
//	if(f>100) printf("error\n");
//	else if (f>=90) printf("A\n");
//	else if (f>=80) printf("B\n");
//	else if (f>=70) printf("C\n");
//	else if (f>=60) printf("D\n");
//	else if (f>=0) printf("E\n");
//	else printf("error\n");

//5.8
//...

//5.7 
//	char c;
//	scanf("%c",&c);
//	if (c>='a' && c<='z'){
//		c-=32;
//	}else if (c>='A' && c<='Z'){
//		c+=32;
//	}
//	printf("%c %d\n",c,c);



//5.4
//	double base;
//	int year;
//	scanf("%lf%d", &base,&year);
//	if(year<=0){
//		printf("error!");
//		return;
//	}
//	double rate;
//	switch(year){
//		case 1:
//			rate=2.25;
//			break;
//		case 2:
//			rate=2.43;
//			break;
//		case 3:
//		case 4:
//			rate=2.70;
//			break;
//		case 5:
//		case 6:
//		case 7:
//			rate=2.88;
//			break;
//		default: 
//			rate=3.00;
//			break;
//	}
//	double total = base * (1 + rate) *year;
//	printf("%lf\n",total);//	double base;
//	int year;
//	scanf("%lf%d", &base,&year);
//	if(year<=0){
//		printf("error!");
//		return;
//	}
//	double rate;
//	switch(year){
//		case 1:
//			rate=2.25;
//			break;
//		case 2:
//			rate=2.43;
//			break;
//		case 3:
//		case 4:
//			rate=2.70;
//			break;
//		case 5:
//		case 6:
//		case 7:
//			rate=2.88;
//			break;
//		default: 
//			rate=3.00;
//			break;
//	}
//	double total = base * (1 + rate) *year;
//	printf("%lf\n",total);



//5.3
//#include <math.h>
//	double a,b,c;
//	scanf("%lf %lf %lf",&a,&b,&c);
// //if (a+b>c && a+c>b && b+c>a){
//	if( (a+b>c) && (a+c>b) && (b+c>a) ){
//		double s=(a+b+c)/2;
//		double area=sqrt(s*(s-a)*(s-b)*(s-c));
//		printf("%lf\n",area);
//	}else{
//		printf("Can not form a triangle.\n");
//	}



//5.2 
//	int a;
//	scanf("%d",&a);
//	if(a%2) printf("odd\n");
//	else printf("even\n");



//5.1
//	double d;
//	scanf("%lf",&d);
//	if(d<0){
//		d=-d;
//	}
//	printf("%lf\n",d);
//	return 0;
