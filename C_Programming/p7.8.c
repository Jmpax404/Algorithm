#include <stdio.h>

int main(){
	int c, i,k;
	c=k=1;
	int flag=0;
	while(flag==0){
		flag=1;
		c=c*5+1;
		for(i=2;i<=5;i++){
			c=c*5;
			if(c%4!=0){
				flag=0;
				break;
			}else{
				c=c/4+1;
			}
		}
		if(flag==0){
			k++;
			c=k;
		}
	}
	printf("%d\n",c);
	return 0;
}
