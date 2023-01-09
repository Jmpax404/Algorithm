#include <stdio.h>

typedef struct {
    int index;
    int val;
} Item;

int main(){
	int n;
    scanf("%d",&n);
    Item items[20];
    for(int i=0;i<n;i++){
        scanf("%d",&items[i].val);
        items[i].index=i;
	}
	//dfs
	Item *st[20];
	int si=-1;
	int total =0,cur=0;
	int count=0;
	while(cur<n){
		st[++si]=&items[cur];
		total += items[cur].val;
		int leave=0;
		if(total>=40){
			leave=1;
			if(total==40){
				count++;
			}
		}
		if(cur<n-1 && !leave){
			cur++;
		}else{
			Item *item;
			do{
				item = st[si--];
				cur= item->index + 1;
				total-=item->val;
			}while(cur>=n && si>-1);
		}
	}
	printf("%d\n",count);
	return 0;
}
