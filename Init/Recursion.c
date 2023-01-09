#include <stdio.h>

typedef struct {
	char c;
	int index;
}Item;

void printfStack(Item *st[],int si){
	int i;
	for(i=0;i<=si;i++){
		printf("%c",st[i]->c);	
	}
	printf("\n");
}

//Full Permutation
main(){
	char data[]={'a','b','c','d','e','f','g','h','i','j',
		'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	};
	int n=26;
	Item items[n];
	int i;
	for(i=0;i<n;i++){
		items[i].c=data[i];
		items[i].index=i;
	}
	Item *st[n];
	int si=-1;
	int cur=0;
	int times = 0 ;
	while(cur<n){
		st[++si]=&items[cur];
		printfStack(st,si);
		cur++;
		if(cur>=n){
			Item *item;
			do{
				item=st[si--];
				cur=item->index + 1;
			}while(cur>=n && si>-1);	
		}
	}
}
