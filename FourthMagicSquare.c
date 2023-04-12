#include <stdio.h>
#include <math.h>

int hash[10000];

int isPrime(int n){
	int i;
	int end=sqrt(n);
	int isPrime=1;
	for(i=2;i<=end;i++){
		if(n%i==0){
			isPrime=0;
			break;
		}
	}
	return isPrime;
}

int getReversiblePrimeNumbers(int arr[]){
	int t;
	int n=0;
	int i,j,k,l;
	for(i=1;i<=9;i++){
		for(j=0;j<=9;j++){
			for(k=0;k<=9;k++){
				for(l=0;l<=9;l++){
					if(isPrime(t=i*1000+j*100+k*10+l) && isPrime(l*1000+k*100+j*10+i)){
						arr[n++]=t;
						hash[t]=1;
					}
				}	
			}	
		}	
	}
	return n;
}

void printMagicSquare(int arr[],int n){
	int i,j,k,l;
	int s[4][4]={0};
	int t,m;
	int t1,t2,t3,t4,t5,t6;
	int no=1;
	int i1,i2;
	for(i=0;i<n;i++){
		t=arr[i];
		for(m=3;m>=0;m--){
			s[0][m]=t%10;
			t/=10;
		}
		for(j=0;j<n;j++){
			t=arr[j];
			for(m=3;m>=0;m--){
				s[1][m]=t%10;
				t/=10;
			}
			for(k=0;k<n;k++){
				t=arr[k];
				for(m=3;m>=0;m--){
					s[2][m]=t%10;
					t/=10;
				}
				for(l=0;l<n;l++){
					t=arr[l];
					for(m=3;m>=0;m--){
						s[3][m]=t%10;
						t/=10;
					}
					//judge
					t1=s[0][0]*1000+s[1][0]*100+s[2][0]*10+s[3][0];
					t2=s[0][1]*1000+s[1][1]*100+s[2][1]*10+s[3][1];
					t3=s[0][2]*1000+s[1][2]*100+s[2][2]*10+s[3][2];
					t4=s[0][3]*1000+s[1][3]*100+s[2][3]*10+s[3][3];
					t5=s[0][0]*1000+s[1][1]*100+s[2][2]*10+s[3][3];
					t6=s[0][3]*1000+s[1][2]*100+s[2][1]*10+s[3][0];
					if(hash[t1] && hash[t2] && hash[t3] && hash[t4] 
						&& hash[t5] && hash[t6]){
						printf("No. %d\n",no++);
						for(i1=0;i1<4;i1++){
							for(i2=0;i2<4;i2++){
								printf("%6d",s[i1][i2]);
							}
							printf("\n");
						}
					}
				}
			}
		}	
	}
}

int main(){
	int arr[500];
	int n = getReversiblePrimeNumbers(arr); //204
	printMagicSquare(arr,n);	
	return 0;
}
/*

No. 1
     1     1     9     3
     1     0     0     9
     9     2     2     1
     3     1     9     1
No. 2
     1     1     9     3
     1     0     2     1
     9     0     2     9
     3     9     1     1
No. 3
     1     1     9     3
     1     2     0     1
     9     2     0     9
     3     9     1     1
No. 4
     1     1     9     3
     1     2     2     9
     9     0     0     1
     3     1     9     1
No. 5
     1     1     9     3
     7     0     4     3
     3     6     9     7
     3     9     1     1
No. 6
     1     1     9     3
     7     2     5     3
     3     8     2     1
     3     3     1     9
No. 7
     1     1     9     3
     7     2     5     3
     3     8     5     1
     3     3     1     9
No. 8
     1     1     9     3
     7     4     5     7
     3     8     2     1
     3     7     1     9
No. 9
     1     1     9     3
     7     9     6     3
     3     4     0     7
     3     9     1     1
No. 10
     1     1     9     3
     9     0     0     1
     1     2     2     9
     3     1     9     1
No. 11
     1     1     9     3
     9     0     1     1
     1     6     6     9
     3     9     1     1
No. 12
     1     1     9     3
     9     0     1     3
     1     6     6     9
     3     9     1     1
No. 13
     1     1     9     3
     9     0     2     9
     1     0     2     1
     3     9     1     1
No. 14
     1     1     9     3
     9     0     4     1
     1     3     9     9
     3     3     7     1
No. 15
     1     1     9     3
     9     2     0     9
     1     2     0     1
     3     9     1     1
No. 16
     1     1     9     3
     9     2     2     1
     1     0     0     9
     3     1     9     1
No. 17
     1     1     9     3
     9     2     5     7
     3     8     2     1
     3     3     1     9
No. 18
     1     1     9     3
     9     2     5     7
     3     8     5     1
     3     3     1     9
No. 19
     1     1     9     3
     9     4     7     9
     1     3     8     1
     3     9     1     7
No. 20
     1     1     9     3
     9     6     6     1
     1     1     0     9
     3     9     1     1
No. 21
     1     1     9     3
     9     6     6     1
     3     1     0     9
     3     9     1     1
No. 22
     1     1     9     3
     9     9     2     3
     1     0     0     9
     3     1     9     1
No. 23
     1     7     3     3
     1     0     6     9
     9     4     9     1
     3     3     7     1
No. 24
     1     7     3     3
     1     2     8     3
     9     5     2     1
     3     3     1     9
No. 25
     1     7     3     3
     1     2     8     3
     9     5     5     1
     3     3     1     9
No. 26
     1     7     3     3
     1     4     8     7
     9     5     2     1
     3     7     1     9
No. 27
     1     7     3     3
     1     9     4     9
     9     6     0     1
     3     3     7     1
No. 28
     1     7     3     3
     9     2     2     7
     1     0     2     1
     3     7     1     9
No. 29
     1     7     3     3
     9     9     3     1
     1     4     0     9
     3     9     1     1
No. 30
     1     9     1     3
     1     0     0     9
     9     2     2     1
     3     9     1     1
No. 31
     1     9     1     3
     1     0     2     1
     9     0     2     9
     3     1     9     1
No. 32
     1     9     1     3
     1     0     3     3
     9     4     9     7
     3     1     9     1
No. 33
     1     9     1     3
     1     0     6     9
     9     1     6     1
     3     1     9     1
No. 34
     1     9     1     3
     1     0     6     9
     9     1     6     1
     3     3     9     1
No. 35
     1     9     1     3
     1     2     0     1
     9     2     0     9
     3     1     9     1
No. 36
     1     9     1     3
     1     2     2     9
     9     0     0     1
     3     9     1     1
No. 37
     1     9     1     3
     1     4     3     9
     9     7     8     1
     3     9     1     7
No. 38
     1     9     1     3
     1     6     1     9
     9     6     0     1
     3     1     9     1
No. 39
     1     9     1     3
     1     9     0     1
     9     2     0     9
     3     3     9     1
No. 40
     1     9     1     3
     7     2     0     7
     3     2     2     1
     3     7     1     9
No. 41
     1     9     1     3
     7     9     4     9
     3     3     0     1
     3     1     9     1
No. 42
     1     9     1     3
     9     0     0     1
     1     2     2     9
     3     9     1     1
No. 43
     1     9     1     3
     9     0     0     1
     3     2     9     9
     3     9     1     1
No. 44
     1     9     1     3
     9     0     2     9
     1     0     2     1
     3     1     9     1
No. 45
     1     9     1     3
     9     1     7     3
     3     3     8     9
     3     3     9     1
No. 46
     1     9     1     3
     9     2     0     9
     1     2     0     1
     3     1     9     1
No. 47
     1     9     1     3
     9     2     2     1
     1     0     0     9
     3     9     1     1
No. 48
     1     9     3     3
     1     2     8     3
     9     5     2     1
     3     7     1     9
No. 49
     1     9     3     3
     1     2     8     3
     9     5     5     1
     3     7     1     9
No. 50
     1     9     3     3
     1     6     1     9
     9     6     0     1
     3     1     9     1
No. 51
     1     9     3     3
     9     0     2     9
     1     0     9     1
     3     1     9     1
No. 52
     1     9     3     3
     9     1     3     3
     1     7     8     9
     3     3     9     1
No. 53
     1     9     3     3
     9     8     3     3
     3     7     1     9
     3     1     9     1
No. 54
     1     9     3     3
     9     8     7     1
     3     3     1     9
     3     3     9     1
No. 55
     3     1     9     1
     1     0     0     9
     9     2     2     1
     1     1     9     3
No. 56
     3     1     9     1
     1     0     0     9
     9     9     2     3
     1     1     9     3
No. 57
     3     1     9     1
     1     0     2     1
     9     0     2     9
     1     9     1     3
No. 58
     3     1     9     1
     1     0     9     1
     9     0     2     9
     1     9     3     3
No. 59
     3     1     9     1
     1     2     0     1
     9     2     0     9
     1     9     1     3
No. 60
     3     1     9     1
     1     2     2     9
     9     0     0     1
     1     1     9     3
No. 61
     3     1     9     1
     3     3     0     1
     7     9     4     9
     1     9     1     3
No. 62
     3     1     9     1
     3     7     1     9
     9     8     3     3
     1     9     3     3
No. 63
     3     1     9     1
     7     0     2     7
     1     2     2     3
     9     1     7     3
No. 64
     3     1     9     1
     9     0     0     1
     1     2     2     9
     1     1     9     3
No. 65
     3     1     9     1
     9     0     2     9
     1     0     2     1
     1     9     1     3
No. 66
     3     1     9     1
     9     1     6     1
     1     0     6     9
     1     9     1     3
No. 67
     3     1     9     1
     9     2     0     9
     1     2     0     1
     1     9     1     3
No. 68
     3     1     9     1
     9     2     2     1
     1     0     0     9
     1     1     9     3
No. 69
     3     1     9     1
     9     3     4     1
     1     8     7     9
     7     1     9     3
No. 70
     3     1     9     1
     9     4     9     7
     1     0     3     3
     1     9     1     3
No. 71
     3     1     9     1
     9     6     0     1
     1     6     1     9
     1     9     1     3
No. 72
     3     1     9     1
     9     6     0     1
     1     6     1     9
     1     9     3     3
No. 73
     3     3     1     9
     3     8     2     1
     7     2     5     3
     1     1     9     3
No. 74
     3     3     1     9
     3     8     2     1
     9     2     5     7
     1     1     9     3
No. 75
     3     3     1     9
     3     8     5     1
     7     2     5     3
     1     1     9     3
No. 76
     3     3     1     9
     3     8     5     1
     9     2     5     7
     1     1     9     3
No. 77
     3     3     1     9
     9     5     2     1
     1     2     8     3
     1     7     3     3
No. 78
     3     3     1     9
     9     5     5     1
     1     2     8     3
     1     7     3     3
No. 79
     3     3     7     1
     1     3     9     9
     9     0     4     1
     1     1     9     3
No. 80
     3     3     7     1
     3     8     2     1
     1     2     5     9
     9     1     3     3
No. 81
     3     3     7     1
     3     8     2     1
     1     5     5     9
     9     1     3     3
No. 82
     3     3     7     1
     7     2     2     9
     1     2     0     1
     9     1     7     3
No. 83
     3     3     7     1
     7     8     4     1
     1     2     5     9
     9     1     7     3
No. 84
     3     3     7     1
     9     4     9     1
     1     0     6     9
     1     7     3     3
No. 85
     3     3     7     1
     9     6     0     1
     1     9     4     9
     1     7     3     3
No. 86
     3     3     9     1
     1     7     8     9
     9     1     3     3
     1     9     3     3
No. 87
     3     3     9     1
     3     3     1     9
     9     8     7     1
     1     9     3     3
No. 88
     3     3     9     1
     3     3     8     9
     9     1     7     3
     1     9     1     3
No. 89
     3     3     9     1
     3     8     2     1
     1     2     5     9
     9     1     7     3
No. 90
     3     3     9     1
     3     8     2     1
     1     5     5     9
     9     1     7     3
No. 91
     3     3     9     1
     9     1     6     1
     1     0     6     9
     1     9     1     3
No. 92
     3     3     9     1
     9     2     0     9
     1     9     0     1
     1     9     1     3
No. 93
     3     7     1     9
     1     0     2     1
     9     2     2     7
     1     7     3     3
No. 94
     3     7     1     9
     3     2     2     1
     7     2     0     7
     1     9     1     3
No. 95
     3     7     1     9
     3     8     2     1
     7     4     5     7
     1     1     9     3
No. 96
     3     7     1     9
     9     5     2     1
     1     2     8     3
     1     9     3     3
No. 97
     3     7     1     9
     9     5     2     1
     1     4     8     7
     1     7     3     3
No. 98
     3     7     1     9
     9     5     5     1
     1     2     8     3
     1     9     3     3
No. 99
     3     9     1     1
     1     0     0     9
     9     2     2     1
     1     9     1     3
No. 100
     3     9     1     1
     1     0     2     1
     9     0     2     9
     1     1     9     3
No. 101
     3     9     1     1
     1     1     0     9
     9     6     6     1
     1     1     9     3
No. 102
     3     9     1     1
     1     2     0     1
     9     2     0     9
     1     1     9     3
No. 103
     3     9     1     1
     1     2     2     9
     9     0     0     1
     1     9     1     3
No. 104
     3     9     1     1
     1     4     0     9
     9     9     3     1
     1     7     3     3
No. 105
     3     9     1     1
     1     6     6     9
     9     0     1     1
     1     1     9     3
No. 106
     3     9     1     1
     1     6     6     9
     9     0     1     3
     1     1     9     3
No. 107
     3     9     1     1
     3     1     0     9
     9     6     6     1
     1     1     9     3
No. 108
     3     9     1     1
     3     2     9     9
     9     0     0     1
     1     9     1     3
No. 109
     3     9     1     1
     3     4     0     7
     7     9     6     3
     1     1     9     3
No. 110
     3     9     1     1
     3     5     2     7
     1     2     8     3
     9     1     3     3
No. 111
     3     9     1     1
     3     5     2     7
     1     5     8     3
     9     1     3     3
No. 112
     3     9     1     1
     3     6     9     7
     7     0     4     3
     1     1     9     3
No. 113
     3     9     1     1
     7     5     2     9
     1     2     8     3
     9     1     3     3
No. 114
     3     9     1     1
     7     5     2     9
     1     5     8     3
     9     1     3     3
No. 115
     3     9     1     1
     7     5     4     7
     1     2     8     3
     9     1     7     3
No. 116
     3     9     1     1
     9     0     0     1
     1     2     2     9
     1     9     1     3
No. 117
     3     9     1     1
     9     0     2     9
     1     0     2     1
     1     1     9     3
No. 118
     3     9     1     1
     9     2     0     9
     1     2     0     1
     1     1     9     3
No. 119
     3     9     1     1
     9     2     2     1
     1     0     0     9
     1     9     1     3
No. 120
     3     9     1     1
     9     7     4     9
     1     8     3     1
     7     1     9     3
No. 121
     3     9     1     7
     1     3     8     1
     9     4     7     9
     1     1     9     3
No. 122
     3     9     1     7
     9     7     8     1
     1     4     3     9
     1     9     1     3
No. 123
     7     1     9     3
     1     8     3     1
     9     7     4     9
     3     9     1     1
No. 124
     7     1     9     3
     1     8     7     9
     9     3     4     1
     3     1     9     1
No. 125
     9     1     3     3
     1     2     5     9
     3     8     2     1
     3     3     7     1
No. 126
     9     1     3     3
     1     2     8     3
     3     5     2     7
     3     9     1     1
No. 127
     9     1     3     3
     1     2     8     3
     7     5     2     9
     3     9     1     1
No. 128
     9     1     3     3
     1     5     5     9
     3     8     2     1
     3     3     7     1
No. 129
     9     1     3     3
     1     5     8     3
     3     5     2     7
     3     9     1     1
No. 130
     9     1     3     3
     1     5     8     3
     7     5     2     9
     3     9     1     1
No. 131
     9     1     7     3
     1     2     0     1
     7     2     2     9
     3     3     7     1
No. 132
     9     1     7     3
     1     2     2     3
     7     0     2     7
     3     1     9     1
No. 133
     9     1     7     3
     1     2     5     9
     3     8     2     1
     3     3     9     1
No. 134
     9     1     7     3
     1     2     5     9
     7     8     4     1
     3     3     7     1
No. 135
     9     1     7     3
     1     2     8     3
     7     5     4     7
     3     9     1     1
No. 136
     9     1     7     3
     1     5     5     9
     3     8     2     1
     3     3     9     1

*/