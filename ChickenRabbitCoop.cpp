#include <cstdio>

int main(){
	int n,a;
	scanf("%d",&n);
	while(n-- > 0){
		scanf("%d",&a);
		int min=a/4;
		while(min >= 0){
			int t=a-min*4;
			if(t % 2 == 0){
				printf("%d", t/2 + min);
				break;
			}
			min--;
		}
		if(min<0){
			printf("0 0\n");
			continue;
		}
		int max=a/2;
		while(max >= 0){
			int t=a-max*2;
			if( t % 4 == 0){
				printf(" %d\n", t/4 + max);
				break;
			}
			max--;
		}
	}
	return 0;
}
