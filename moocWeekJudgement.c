#include <stdio.h>

int main(){
	char c1,c2;
	scanf("%c",&c1);
	switch(c1){
		case 'm':{
			printf("monday\n");
			return 0;
		}
		case 'w':{
			printf("wednesday\n");
			return 0;
		}
		case 'f':{
			printf("friday\n");
			return 0;
		}
		default:{
			scanf(" %c",&c2);
			if(c1=='t'){
				if(c2=='u'){
					printf("tuesday\n");
					return 0;
				}else if(c2=='h'){
					printf("thursday\n");
					return 0;
				}else{
					printf("error");
					return 0;
				}
			} else if(c1=='s'){
				if(c2=='a'){
					printf("saturday\n");
					return 0;
				}else if(c2=='u'){
					printf("sunday\n");
					return 0;
				}else{
					printf("error");
					return 0;
				}
			}else{
				printf("error");
				return 0;
			}
		}
	}
	return 0;
}
