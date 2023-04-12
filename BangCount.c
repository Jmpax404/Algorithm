#include <stdio.h>

int main(){
	int i;
	int t1,t2,t3;
	t1=21*5,t2=21*6,t3=21*7;
	int count = t1/5+t1/6+t1/7-t1/30-t1/35-t1/42+t1/210;
	count += (t2/6+t2/7-t2/42)-(t1/6+t1/7-t1/42);
	count += t3/7-t2/7;
	printf("%d\n",count);
	return 0;
}
