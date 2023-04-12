#include <stdio.h>

long Fun(long M, long T, long U, long F, long D, char str[]){
	long i;
	long total=0;
	for(i=0;i<T;i++){
		switch(str[i]){
			case 'u':
			case 'd':{
				total+=(U+D);
				break;
			}
			case 'f':{
				total+=F*2;
				break;
			}
		}
		if(total>=M){
			return i;
		}
	}
	return i;
}

int main(){
	long M,T,U,F,D;
	printf("Input M,T,U,F,D:");
	scanf("%ld%ld%ld%ld%ld",&M,&T,&U,&F,&D);
	printf("Input conditions of road:");
	char s[100001];
	scanf("%s",s);
	long num = Fun( M,  T,  U,  F,  D, s);
	printf("num=%ld\n",num);
	return 0;
}
