#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <cmath>

#define N 100010

int randPatition(int arr[],int left, int right) {
	int r = round(rand() * 1.0 / RAND_MAX * (right-left) + left);
	int t=arr[r];
	arr[r]=arr[left];
	arr[left]=t;
	int s=left;
	int e=right;
	while(s<e){
		while(s<e && arr[e]>t){
			e--;
		}
		arr[s]=arr[e];
		while(s<e && arr[s]<=t){
			s++;
		}
		arr[e]=arr[s];
	}
	arr[s]=t;
	return s;
}

int randSelect(int arr[],int left,int right,int k){
	if(left>=right){
		if(k==1){
			return arr[left];
		}else{
			return 0;//not found
		}
	}
	int p = randPatition(arr,left,right);
	int m = right - p + 1;
	if(m==k){
		return arr[p];
	}else if(m>k){
		return randSelect(arr,p+1,right,k);
	}else{
		return randSelect(arr,left,p-1,k-m);
	}
}

int main(){
	srand(unsigned(time(NULL)));
	int arr[N];
	int k;
	int n=0;
	while(~scanf("%d",&k)){
		arr[n++]=k;
	}
	n--;
	int res = randSelect(arr,0,n-1,k);
	printf("%d\n",res);
	return 0;
}
