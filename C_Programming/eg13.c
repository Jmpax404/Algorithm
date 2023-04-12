#include <stdio.h>
#include <stdlib.h>

int main(){
	printf("%d\n",SEEK_CUR);
	FILE *f = fopen("a.txt","w");
	if(f==NULL){
		printf("Failure to open the file.\n");
		exit(0);
	}
	char c;
	while((c=getchar())!=EOF){
		fputc(c,f);
	}
	fclose(f);
	
	
	return 0;
	
}
 
