#include <stdio.h>

char *printStr(int n){
	static char *error ="Illegal month.";
	static char *months[]={
		"January","February","March","April",
		"May","June","July","August",
		"September","October","November","December"
	};
	if(n>=1 && n<=12){
		return months[n-1];
	}else{
		return error;
	}
}

int main(){
	int n;
	scanf("%d",&n);
	printf("%s\n",printStr(n));
	return 0;
}
