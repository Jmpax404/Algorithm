#include <stdio.h>
#include <math.h>

int main(){

}

//6.21
//	const int a=5,b=6,c=7;
//	const int t=21;
//	int min1=t*a,min2=t*b;
//	int ab=min1/(a*b), ac=min1/(a*c), bc=min2/(b*c);
//	int abc=min1/(a*b*c);
//	int total = t*3-ab-ac-bc+abc;
//	printf("%d\n",total);
//	return 0;



//6.20
//	int i,j;
//	int k,m;
//	int a[4];
//	for(i=32;i<=99;i++){
//		m=k=i*i;
//		for(j=3;j>=0;j--){
//			a[j]=k%10;
//			k/=10;
//		}
//		if(a[0]==a[1] && a[2]==a[3] && a[0]!=a[2]){
//			printf("%d\n",m);
//		}
//	}
//	return 0;



//6.19
//	int i =0;
//	double a=0,b=0;
//	double term = 0.01;
//	for(i=1;i<=30;i++){
//		a+=100000;
//		b+=term;
//		term*=2;
//	}
//	printf("Stranger give out    : %15lf\n",a);
//	printf("Millionaire give out : %15lf\n",b);



//6.18
//	int i,j;
//	for (i=1;i<=9;i++){
//		printf("%-4d",i);
//	}
//	printf("\n\n");
//	for (i=1;i<=9;i++){
//		printf("%-4c",'-');
//	}
//	printf("\n\n");
//	for (i=1;i<=9;i++){
//		for (j=1;j<i;j++) printf("%-4c",' ');//3
//		for (j=i;j<=9;j++){//3
////		for (j=1;j<=i;j++){//2
////		for (j=1;j<=9;j++){//1
//			printf("%-4d",i*j);
//		}
//		printf("\n\n");
//	}
