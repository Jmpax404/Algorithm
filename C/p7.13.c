#include <stdio.h>
#include <math.h>

int findMinFactor(int m){
	if(m<2) return 0;
	int i;
	int end = (int) sqrt(m);
	for (i=2;i<=end;i++){
		if(m%i==0){
			return i;
		}
	}
	return -1;
}

int main(){
	int m,i;
	scanf("%d",&m);
	if(m<2){
		return 0;
	}
	int end = (int) sqrt(m);
	int isPrime=1;
	int j=findMinFactor(m);
	if(j==-1){
		printf("It is a prime number.\n");
		return 0;
	}else{
		printf("%d = %d",m,j);
	}
	m/=j;
	while((j=findMinFactor(m)) != -1){
		printf(" * %d",j);
		m/=j;
	}
	printf(" * %d\n",m);
	return 0;
}



//task 5
//int isPerfect(int m){
//	if(m<1) return 0;
//	int i,end = m/2;
//	int total=0; 
//	for (i=1;i<=end;i++){
//		if(m%i==0){
//			total+=i;
//		}
//	}
//	return total==m;
//}



//task 4
//#define isPrimeFunc isPrime2
//
//int isPrime2(int m){
//	if(m<2) return 0;
//	int i,end = (int)sqrt(m);
//	for (i=2;i<=end;i++){
//		if(m%i==0) return 0;
//	}
//	return 1;
//}
//
//void printFactors(int m){
//	if(m<2) return 0;
//	int i,end = m-1;
//	for (i=2;i<=end;i++){
//		if(m%i==0){
//			printf(" %d",i);
//		}
//	}
//	printf("\n");
//	return 1;
//}



//task 3
//	int n;
//	scanf("%d",&n);
//	int i,total=0;
//	for(i=1;i<n;i++){
//		if(isPrimeFunc(i)){
//			total++;
//		}	
//	}
//	printf("%d\n",total);
//	return 0;



//task 1, 2
//	int m;
//	scanf("%d",&m);
//	if(isPrimeFunc(m)){
//		printf("%d is a prime number.\n",m);
//	}else{
//		printf("%d is not a prime number.\n",m);
//	}
//	return 0;



//int isPrime1_3(int m){
//	if(m<2) goto notPrime;
//	int i=2;
//cal:
//	if (m%i==0 && i<m) goto notPrime;
//	i++;
//	if(i>=m){
//		goto success;
//	}else{
//		goto cal;
//	}
//notPrime:
//	return 0;
//success:
//	return 1;
//}
//
//int isPrime1_2(int m){
//	if(m<2) return 0;
//	int i=2;
//	while(i<m && m%i!=0){
//		i++;
//	}
//	if(i!=m){
//		return 0;
//	}else{
//		return 1;
//	}
//}
//
//int isPrime1_1(int m){
//	if(m<2) return 0;
//	int i;
//	for (i=2;i<m;i++){
//		if(m%i==0){
//			return 0;
//		}
//	}
//	return 1;
//}
