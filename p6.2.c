#include <stdio.h>

int main(){
	int i,j,k,c;
	for(i=1;i<10;i++){
		for(j=1;j<20;j++){
			k=50-i-j;//k must be positive
			if(10*i+5*j+k==100){
				printf("(10,5,1) -> (%d,%d,%d)\n",i,j,k);
				c++;
			}
		}
	}
	printf("Total: %d\n",c);
	return 0;
}

//6.16
//	int i,j,k;
//	for(i=0;i<20;i++){
//		for(j=0;j<=33;j++){
//			for (k=0;k<100;k+=3){
//				if(i+j+k == 100 && 5*i+3*j+k/3 == 100)
//					printf("(M,F,C) -> (%d,%d,%d)\n",i,j,k);
//			}
//		}
//	}
//	return 0;



//6.15 
//	//x+y=a
//	//2x+4y=b
//	int a = 98, b=386;
//	int c=(4*a-b)/2;
//	printf("Chicken: %d\n",c);
//	printf("Rabbit: %d\n",a-c);
//	return 0;



//6.14
//	#define TP 30
//	#define TM 50
//	int i,j,k;
//	for(i=1;i<TP;i++){
//		for(j=1;j<TP;j++){
//			if(i*3+j*2+(k=TP-i-j) == TM) 
//			printf("(M,F,C) = (%d,%d,%d)\n",i,j,k);
//		}
//	}



//6.13
//	int d,ans=0;
//	while(1){
//		scanf("%d",&d);
//		if(d>0){
//			ans+=d;
//		}else if(d==0){
//			break;	
//		}
//	}
//	printf("Total: %d\n",ans);
//	return 0;



//6.12
//	int d,ans=0;
//	while(1){
//		scanf("%d",&d);
//		if(d>0){
//			ans+=d;
//		}else{
//			break;
//		}
//	}
//	printf("Total: %d\n",ans);
//	return 0;



//6.11
//	int n;
//	scanf("%d",&n);
//	if(n<=1){
//		printf("Unsolvable\n");
//		return 0;	
//	}
//	long ans=1;
//	long term=1;
//	int i=1;
//	do{
//		printf("%5d",i);
//		i++;
//		term*=i;
//		ans+=term;
//	}while(ans<n);
