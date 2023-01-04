#include <cstdio>
#include <algorithm>

using namespace std;

typedef struct{
	int x;
	int y;
}Point;

bool cmp(Point p1,Point p2){
	return p1.y>p2.y;
}

int main(){
	Point ps[1000];
	int n=0;
	while(~scanf("%d%d",&ps[n].x,&ps[n].y)) n++;
	sort(ps,ps+n,cmp);
	int f=ps[0].y,count=0;
	int x,y;
	for(int i=0;i<n;i++){
		x=ps[i].x;
		y=ps[i].y;
		if(y<=f){
			printf("(%d,%d)\n",x,y);
			count++;
			f=x;
		}
	}
	printf("Count: %d\n",count);
	return 0;
}
