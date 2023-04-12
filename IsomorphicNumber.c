#include <stdio.h>

int num2str(int num, int s[]){
	int i=0;
	while(num>0){
		s[i++]=num%10;
		num/=10;
	}
	return i;
}

int main(){
	int i,m;
	int s1[2],s2[4];
	int n1,n2;
	int j,k;
	int noFlag;
	for(i=1;i<=99;i++){
		m = i*i;
		n1=num2str(i,s1);
		n2=num2str(m,s2);
		noFlag=0;
		for(j=0,k=0;j<n1;j++,k++){
			if(s1[j]!=s2[k]){
				noFlag=1;
				break;
			}
		}
		if(noFlag==0){
			printf("m=%3d\t\tm*m=%6d\n",i,m);
		}
	}
	return 0;
}
