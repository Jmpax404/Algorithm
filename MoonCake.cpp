#include <cstdio>
#include <algorithm>

using namespace std;

typedef struct{
	double count;
	double total;
	double unit;
}Item;

bool cmp(Item item1,Item item2){
	return item1.unit>item2.unit;
}

int main (){
	int n,m;
	scanf("%d%d",&n,&m);
	Item items[n];
	for(int i=0;i<n;i++){
		scanf("%lf",&items[i].count);
	}
	for(int i=0;i<n;i++){
		scanf("%lf",&items[i].total);
		items[i].unit=items[i].total/items[i].count;
	}
	sort(items,items+n,cmp);
	int t,k=0;
	double profit=0.0;
	while(m>0&&k<n){
		t=m-items[k].count;
		if(t>=0){
			profit+=items[k].total;
			m=t;
		}else{
			profit+=m*items[k].unit;
			m=0;
		}
		k++;
	}
	printf("%.2lf\n",profit);
	return 0;
}
