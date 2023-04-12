#include <stdio.h>

int arr[128];
int n=-10086;

int CommonFactors(int a, int b){
	if(n==-10086){
		int i;
		n=-1;
		int end = a<b?a:b;
		for(i=1;i<=end;i++){
			if(a%i==0 && b%i==0){
				arr[++n]=i;
			}
		}
		if(n==-1){
			return -1;
		}else{
			n--;
			return arr[n+1];
		}
	} else if (n==-1){
		return -1;
	} else{
		n--;
		return arr[n+1];
	}
}

int main(){
	int a,b;
	printf("Input a and b:\n");
	scanf("%d,%d",&a,&b);
	int c,i=1;
	while((c=CommonFactors(a,b))!=-1){
		printf("Common factor %d is %d\n",i,c);
	}
	return 0;
}
