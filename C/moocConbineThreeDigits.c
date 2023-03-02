#include<stdio.h>
#include <string.h>

int main(){
    int n1, n2, n3;
    int i, j,k,m;
    // traverse and find the three numbers
    for (i = 0; i < 10; i++){
        for (j = 0; j < 10; j++){
            for(k = 0; k < 10; k++){
            	// avoid duplicates
                if (i == j || j == k || i==k) continue;
                n1 = i * 100 + j * 10 + k;
                n2 = n1 * 2;
                n3 = n1 * 3;
                if(n2>999 || n3>999) { continue; }
				int arr[10]={0};
				memset(arr,0,sizeof(arr));
				arr[i] = arr[j] = arr[k] = 1;
				arr[n2%10]++;
				arr[n2/10%10]++;
				arr[n2/100]++;
				arr[n3%10]++;
				arr[n3/10%10]++;
				arr[n3/100]++;
				int duplicate=0;
				for(m=0;m<10;m++){
					if (arr[m]>1){
						duplicate=1;
						break;	
					}
				}
				if(!duplicate){
					printf("%d %d %d\n",n1,n2,n3);
				}
            }
        }	
    }
    return 1;
}
