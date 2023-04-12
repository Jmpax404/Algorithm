#include <stdio.h>

int main(){
	char sex,sports,diet;
	double faHeight,moHeight;
	double ans;
	//input
	printf("sex(F or M):");
	if(scanf("%c",&sex)!=1){
		printf("sex input error.\n");
		return -1;
	}
	printf("faHeight(cm):"); 
	scanf("%lf",&faHeight);
	printf("moHeight(cm):"); 
	scanf("%lf",&moHeight);
	printf("sports(Y or N):");;
	char t1,t2;
	scanf(" %c",&sports);// !!!
	printf("diet(Y or N):");
	scanf(" %c",&diet);// !!!
	//handle
	if (sex=='F'){
		ans = (faHeight*0.923 + moHeight) / 2;
	}else if (sex =='M'){
		ans = (faHeight + moHeight) * 0.54;
	}else{
		printf("sex input error.\n");
		return -1;
	}
	if(sports=='Y') ans *= 1.02;
	if(diet=='Y') ans *= 1.015;
	printf("Your height may be %lf cm.\n",ans);
	return 0;
}
