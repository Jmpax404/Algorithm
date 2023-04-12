#include <stdio.h>

void move(int topMost, int bottomMost, int startCol, int endCol){
	int anotherCol =0, i; 
	for(i=1;i<=3;i++){
		if (i!=startCol && i!=endCol){
			anotherCol=i;
			break;
		}
	}
	if (topMost == bottomMost){
		printf("[%d] %d -> %d\n",topMost,startCol,endCol);
	}else{
		move(topMost,bottomMost-1,startCol,anotherCol);
		move(bottomMost,bottomMost,startCol,endCol);
		move(topMost,bottomMost-1,anotherCol,endCol);
	}
}

int main(){
	int n;
	printf("input n(n>=2): ");
	scanf("%d",&n);
	move(1,n,1,2);
	return 0;
}
