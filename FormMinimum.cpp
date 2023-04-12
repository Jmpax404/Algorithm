# include <cstdio>

int ds[10];

int main(){
	for(int i=0;i<10;i++) scanf("%d",&ds[i]);
	int j=1;
	while(!ds[j]) j++;
	printf("%d",j);
	ds[j]--;
	for(int i=0;i<10;i++){
		int km=ds[i];
		for(int k=0;k<km;k++){
			printf("%d",i);
		}
	}
	printf("\n");
	return 0;
}
