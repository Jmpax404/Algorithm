#include <stdio.h>
#include <stdlib.h>
#define N 10

typedef struct data {
	int year;
	int month;
	int day;
}DATE;

typedef struct student {
	long studentID;
	char studentName[20];
	char studentSex;
	DATE birthday;
	int score[4];
	float aver;
}STUDENT;

int inputData(STUDENT stus[]){
	int n;
	printf("students count: ");
	scanf("%d",&n);
	int i;
	printf("studentID\tstudentName\tstudentSex\tbirthday\tfourScores\n");
	printf("[eg.] 100310121 WangGang M 1991 5 19 72 83 90 82\n");
	printf("Please enter %d lines:\n",n);
	STUDENT s;
	for(i=0;i<n;i++){
		scanf("%ld",&s.studentID);
		scanf("%s",&s.studentName);
		scanf(" %c",&s.studentSex);
		scanf("%d",&s.birthday.year);
		scanf("%d",&s.birthday.month);
		scanf("%d",&s.birthday.day);
		scanf("%d",&s.score[0]);
		scanf("%d",&s.score[1]);
		scanf("%d",&s.score[2]);
		scanf("%d",&s.score[3]);
		stus[i]=s;
	}
	return n;
}

void aver(STUDENT stus[],int n){
	int i;
	int *score;
	for(i=0;i<n;i++){
		score=stus[i].score;
		stus[i].aver=(score[0]+score[1]+score[2]+score[3])/4.0;
	}
}

void saveToFile(const char *path,STUDENT stus[],int n){
	FILE *fp;
	if((fp=fopen(path,"w"))==NULL){
		printf("Error when saving!\n");
		exit(0);
	}
	fprintf(fp,"Count: %d\n",n);
	fprintf(fp,"ID\t\tName\t\tSex\tBirth\t\t\tFour Scores\tAver\n");
	int i;
	STUDENT s;
	for(i=0;i<n;i++){
		s=stus[i];
		fprintf(fp,"%ld\t%s\t%c\t%d/%02d/%02d\t%d\t%d\t%d\t%d\t%.1f\n",
			s.studentID,s.studentName,s.studentSex,
			s.birthday.year,s.birthday.month,s.birthday.day,
			s.score[0],s.score[1],s.score[2],s.score[3],s.aver);
	}
	printf("Saving Success!");
	fclose(fp);
}

int findStu(long id, STUDENT *pStu){
	FILE *fp;
	if((fp=fopen("score.txt","r"))==NULL){
		printf("Error when opening data file!\n");
		exit(0);
	}
	char s[128];
	fscanf(fp,"%s",s);//Count:
	int n;
	fscanf(fp,"%d",&n);
	fgetc(fp);//\n
	fgets(s,128,fp);//ID Name Sex Birth Four Scores Averg
	long idCur;
	int i;
	int findFlag=0;
	for(i=0;i<n;i++){
		fscanf(fp,"%ld",&idCur);
		if(idCur==id){
			pStu->studentID=id;
			fscanf(fp,"%s",pStu->studentName);
			fscanf(fp," %c",&pStu->studentSex);
			fscanf(fp,"%d",&pStu->birthday.year);
			fgetc(fp);// / 
			fscanf(fp,"%d",&pStu->birthday.month);
			fgetc(fp);// /
			fscanf(fp,"%d",&pStu->birthday.day);
			fscanf(fp,"%d",&pStu->score[0]);
			fscanf(fp,"%d",&pStu->score[1]);
			fscanf(fp,"%d",&pStu->score[2]);
			fscanf(fp,"%d",&pStu->score[3]);
			fscanf(fp,"%f",&pStu->aver);
			findFlag=1;
			break;
		}
		fgets(s,128,fp);//jump over this line
	}
	fclose(fp);
	if(findFlag==1){
		return 0;
	}else{
		return -1;
	}
}

int main(){
	STUDENT s;
	int state = findStu(100310123,&s);
	if(!state){
		printf("%ld\t%s\t%c\t%d/%02d/%02d\t%d\t%d\t%d\t%d\t%.1f\n",
		s.studentID,s.studentName,s.studentSex,
		s.birthday.year,s.birthday.month,s.birthday.day,
		s.score[0],s.score[1],s.score[2],s.score[3],s.aver);	
	}else{
		printf("Can not find!\n");
	}
	return 0;
}

//13.2
//	STUDENT students[N];
//	int n = inputData(students);
//	aver(students,n);
//	saveToFile("score.txt",students,n);
