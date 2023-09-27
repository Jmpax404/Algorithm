#include <cstdio>
#include <algorithm>

using namespace std;

int main(){
	int num;
	scanf("%d",&num);
	do{
		int arr[4]={0};//make every element be 0
		int an=0;
		while(num!=0){
			arr[an++]=num%10;
			num/=10;
		}
		sort(arr,arr+4);
		int num1=arr[0]*1000+arr[1]*100+arr[2]*10+arr[3];
		int num2=arr[3]*1000+arr[2]*100+arr[1]*10+arr[0];
		if(num2<num1){
			int numt=num1;
			num1=num2;
			num2=numt;
		}
		int t = num2-num1;
		printf("%04d - %04d = %04d\n",num2,num1,t);
		num = t;
	}while(num!=6174 && num!=0);
	return 0;
}
