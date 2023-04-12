#include <stdio.h>
#include <math.h>


int main(){
	int tri[10];
	int i,j,k,t;
	for(i=0;i<10;i++){
		tri[i]=i*i*i;
	}
	for(i=1;i<=9;i++){
		for(j=0;j<=9;j++){
			for(k=0;k<=9;k++) {
				if(tri[i]+tri[j]+tri[k]==(t=i*100+j*10+k)){
					printf("%d\n",t);
				}
			}
		}
	}
	return 0;
}





//6.9
//	double term,res=1;
//	long ex=1;
//	int n=1;
//	do{
//		ex*=n;
//		n++;
//		term=1.0/ex;
//		res+=term;
//	}while(term>=1e-5);
//	printf("%lf,%d\n",res,n);
//	return 0;



//6.8
//	float term, result=0;
//	int n=0;
//	char isNeg='\0';
//	do{
//		term=1.0/(2*n+1);
//		if (isNeg) term=-term;
//		result+=term;
//		isNeg=~isNeg;
//		n++;
//	}while(fabs(term)>=1e-4);
//	result*=4;
//	printf("pi=%f,i=%d\n",result,n);



//6.7
//	float rate,val=100.0;
//	int y=0;
//	scanf("%f",&rate);
//	while(val <= 200){
//		val*=(1+rate);
//		y++;
//	}
//	printf("%d\n",y);
//	return 0;



//6.6
//	int i=1;
//	double x=0;
////	double r=pow(1.01875,12);
//	double r=1+0.01875*12;
//	for (i=1;i<=5;i++){
//		x=(x+1000) / r;
//	}
//	printf("%lf\n",x);



//6.5
//	int i;
//	float v1=(float)5/9;
//	for(i=0;i<=300;i+=10){
//		printf("%4d\t%6.1f\n",i,v1*(i-32));
//	}



//6.4
//	int n, i;
//	scanf("%d",&n);
//	for(i=1;i<=n;i++){
//		printf("%d^2 = %ld\n",i,i*i);
//		printf("%d^3 = %ld\n",i,i*i*i);
//	}
