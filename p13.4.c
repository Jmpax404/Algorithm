#include <stdio.h>
#include <stdlib.h>

void copyFile(const char *src,const char *dst, int isAppend){
	FILE *fpSrc,*fpDst;
	if((fpSrc=fopen(src,"rb")) == NULL){
		printf("Open file error!\n");
		exit(0);
	}
	char *types[]={"wb","ab"};
	if((fpDst=fopen(dst,types[isAppend])) == NULL){
		printf("Open file error!\n");
		fclose(fpSrc);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		exit(0);
	}
	char buff[8];
	int size;
	while((size=fread(buff,1,8,fpSrc))>0){
		fwrite(buff,1,size,fpDst);
	}
	fclose(fpSrc);
	fclose(fpDst);
}

int main(){
	char path1[128];
	char path2[128];
	printf("The file path already existed: ");
	gets(path1);
	printf("The file path of the destination: ");
	gets(path2);
	printf("Processing...\n");
	copyFile(path1,path2,1);
	printf("Finished.\n");
	return 0;
}
