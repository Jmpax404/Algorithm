#include <stdio.h>

void exchange(int *a,int *b, int (*condition)(int a,int b) ){
	int t;
	if((*condition)(*a,*b)){
		t=*a;
		*a=*b;
		*b=t; 
	}
}

int aGreaterb(int a,int b){
	return a>b;
}

int aLowerb(int a,int b){
	return a<b;
}

int aDiffb(int a,int b){
	return a!=b;
}

int main(){
	int a=3;
	int b=2;
	exchange(&a,&b,aDiffb);
	printf("%d %d\n",a,b);
	
//	int c;
//	char* pc=&c;
//	int *pc2=&c;
//	pc=pc2;

//	void *p = NULL;
//	*p=100;
	
	return 0;
}
