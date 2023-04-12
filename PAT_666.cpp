#include <cstdio>

int main(){
	char s[1002];
	fgets(s,1002,stdin);
	char *p=s;
	char c;
	while((c=*p) != '\n'){
		p++;
		if(c!='6'){
			printf("%c",c);
			continue;
		}
		int i=1;
		while((c=*p) != '\n' && c=='6'){
			i++;
			p++;
		}
		if(i>9){
			printf("27");
		}else if(i>3){
			printf("9");
		}else{
			for(int j=i;j>0;j--){
				printf("6");//The character here must be '6'.
			}
		}
	}
	printf("\n");
	return 0;
}
