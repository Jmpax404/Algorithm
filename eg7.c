#include <stdio.h>

int main(){
	int test(){
		printf("foo!\n");
		int r(){
			printf("bar!\n");
			return 2;
		}
		r();
		return 1;
	}
	{
		char s1[10]="Hello", s2[10]="World";
		printf("%s %s\n",s1,s2);
	}
	test();
	
	int i=1;
	
	if (i==0){
		switch(i){
			case 1:{
				break;
			}
			case 2:{
				break;
			}
			case 3:{
				{
					{
						{
							{
								{
									{
										{
											{
												
											}
										}
									}
								}
							}
						}
					}
				}
				break;
			}
		}
	} else if (i==1){
		
	} else if (i==2){
		
	} else if (i==3){
		
		
	} else {
		
	}
	
	return 0;
}
