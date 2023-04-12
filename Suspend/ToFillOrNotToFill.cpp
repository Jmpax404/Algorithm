#include <cstdio>
#include <algorithm>

using namespace std;

typedef struct {
	double unit;
	double distance;
}Station;

bool cmpByDistance(Station s1,Station s2){
	return s1.distance<s2.distance;
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
	printf("%lf %lf %lf %d\n",cm,d,davg,n);
	Station ss[n+1];//the final station is the destination
	for(int i=0;i<n;i++){
		scanf("%lf %lf",&ss[i].unit,&ss[i].distance);
	}
	sort(ss,ss+n,cmpByDistance);
	if(ss[0].distance!=0){//judge for the start station
		printf("The maximum travel distance = %.2lf\n",0.0);
		return 0;
	}
	/*
		For every station, if it fills up here, the distance that it go further is fixed.
	the distance is r=Cmax*davg.
		You can draw some circles for adjacent stations. Only if the point of next station
	is in the range of current station, the car can reach. That is to say, d2<d1+r.
		For the current station, if there are stations at the left to the center of its point,
	the gas spent can be instead by these stations. The left to the center of the point of the
	next station is the condition for the reachable car.
		So if there are cheaper stations between the right to left boarder of next station 
	and the left to the center of current station, you can use the unit of the station 
	instead of the unit of current station.
	*/
	ss[n].distance=d;
	double r = cm * davg;
	double totalPrice=0.0;
	for(int i=0;i<n;i++){
		double minPosition = ss[i+1].distance-r;
		double maxPosition = ss[i].distance;
		if(minPosition>maxPosition){
			return 0;
		}
		int k=i-1;
		double minUnit = ss[i].unit;
		while (k>=0 && ss[k].distance>=minPosition){
			if(ss[k].unit<minUnit){
				minUnit=ss[k].unit;
			}
			k--;
		}
		totalPrice+=(ss[i+1].distance-ss[i].distance) / davg * minUnit;
	}
	printf("%.2lf\n",totalPrice);
	return 0;
}
