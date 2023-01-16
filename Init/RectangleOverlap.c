#include <stdio.h>

typedef struct{
	int x1;//1: left down
	int y1;
	int x2;//2: right up
	int y2;
}Block;

int main(){
	int n,t,i,j,k;
	scanf("%d",&n);
	Block bs[n];
	int xs[n*2],ys[n*2],xn=0,yn=0;
	{//input x1 and insert sort
		scanf("%d",&t);
		xs[xn++]=bs[0].x1=t;
		for(i=1;i<n;i++){
			scanf("%d",&t);
			bs[i].x1=t;
			j=xn-1;
			while(j>=0 && t<xs[j]){
				xs[j+1]=xs[j];
				j--;
			}
			if(t!=xs[j]){//disctinct
				xs[j+1]=t;
				xn++;
			}
		}
	}
	{//input y1 and insert sort
		scanf("%d",&t);
		ys[yn++]=bs[0].y1=t;
		for(i=1;i<n;i++){
			scanf("%d",&t);
			bs[i].y1=t;
			j=yn-1;
			while(j>=0 && t<ys[j]){
				ys[j+1]=ys[j];
				j--;
			}
			if(t!=ys[j]){//disctinct
				ys[j+1]=t;
				yn++;
			}
		}
	}
	{//input x2 and insert sort
		for(i=0;i<n;i++){
			scanf("%d",&t);
			bs[i].x2=t;
			j=xn-1;
			while(j>=0 && t<xs[j]){
				xs[j+1]=xs[j];
				j--;
			}
			if(t!=xs[j]){//disctinct
				xs[j+1]=t;
				xn++;
			}
		}
	}
	{//input y2 and insert sort
		for(i=0;i<n;i++){
			scanf("%d",&t);
			bs[i].y2=t;
			j=yn-1;
			while(j>=0 && t<ys[j]){
				ys[j+1]=ys[j];
				j--;
			}
			if(t!=ys[j]){//disctinct
				ys[j+1]=t;
				yn++;
			}
		}
	}
	Block block;
	int levels[xn][yn],p,q,maxLevel=1;
	memset(levels,0,sizeof(levels));
	for(i=0;i<n;i++){
		block = bs[i];
		j=0;//j is the head, k is the foot
		while(xs[j]<block.x1) j++;
		for(k=j; ;k++){
			if(xs[k]>=block.x2){
				break;
			}
		}
		p=0;//p is the left, q is the right
		while(ys[p]<block.y1) p++;
		for(q=p; ;q++){
			if(ys[q]>=block.y2){
				break;
			}
		}
		int ix,iy;
		for(ix=j+1;ix<=k;ix++){
			for(iy=p+1;iy<=q;iy++){
				levels[ix][iy]++;
				if(levels[ix][iy] > maxLevel) 
					maxLevel = levels[ix][iy];
			}
		}
	}
	printf("%d\n",maxLevel);
	return 0;
}
