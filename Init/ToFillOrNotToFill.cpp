#include <cstdio>
#include <algorithm>

using namespace std;

typedef struct {
	double unit;
	double distance;
}Station;

bool cmpByDistanceDesc(Station s1,Station s2){
	if(s1.distance==s2.distance){
		return s1.unit<s2.unit;//the element in front will be chosen first
	}else{
		return s1.distance>s2.distance;	
	}
}

int findCheapestUnitIndex(Station ss[], int start, int n){
	double min=30001;
	int index=-1;
	for(int i=start;i<n;i++){
		if(ss[i].unit<min){
			min=ss[i].unit;
			index=i;
		}
	}
	return index;
}

int main(){
	double cm;//the maximum capacity of the tank
	double d;//distance to the destination
	double davg;//the average distance per unit gas
	int n;//the number of gas stations
	scanf("%lf %lf %lf %d",&cm,&d,&davg,&n);
	Station ss[n];
	for(int i=0;i<n;i++){
		scanf("%lf %lf",&ss[i].unit,&ss[i].distance);
	}
	//judge the situation which is impossible to reach the destination
	sort(ss,ss+n,cmpByDistanceDesc);
	if(ss[n-1].distance!=0){
		printf("The maximum travel distance = %.2lf\n",0.0);
		return 0;
	}
	double startDistance=0;
	for(int i=n-1;i>=0;i--){
		if ((ss[i].distance-startDistance)/davg>cm){
			printf("The maximum travel distance = %.2lf\n",startDistance+cm*davg);
			return 0;
		}else{
			startDistance=ss[i].distance;
		}
	}
	if((d-startDistance)/davg>cm){//handle the final station
		printf("The maximum travel distance = %.2lf\n",startDistance+cm*davg);
		return 0;
	}
	//if it can reach the destination
	
	
	

	
	return 0;
}
