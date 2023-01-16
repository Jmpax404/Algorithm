#define __USE_MINGW_ANSI_STDIO 1
#include <stdio.h>
#include <math.h>

int main(){
	long double total=0;
	int i;
	for(i=0;i<64;i++){
		total += powl(2,i);
	}
	printf("%Lf\n",total);
	printf("%Lf\n",total/1.42e8);
	return 0;
}
