#include <stdio.h>
#include <stdlib.h>

typedef struct node {
	int data;
	struct node *next;
} Node;

static Node *list;

int insertNode(int val ,int preVal){
	Node *p = list;
	while(p!=NULL && p->data!=preVal){
		p=p->next;
	}
	if(p==NULL){
		return -1;
	}
	Node *node =(Node *)malloc(sizeof(Node));
	node->data=val;
	node->next=p->next;
	p->next=node;
	return 1;
}

int deleteNode(int x){
	Node *p = list;
	Node *p0;
	while(p!=NULL && p->data!=x){
		p0=p;
		p= p -> next;
	}
	if(p==NULL){//containing situations about empty list and the element not find
		return -1;
	}else{//find
		if(p==list){//first node
			list=p->next;
		}else{
			p0->next=p->next;
		}
		free(p);
		return 1;
	}
}

void appendNode(int x){
	Node *node = (Node *)malloc(sizeof(Node));
	node->data=x;
	node->next=NULL;
	if(list==NULL){
		list=node;
		return;
	}	
	Node *p=list;
	while(p->next!=NULL){
		p=p->next;
	}
	p->next=node;
}

int inputInt(const char *text){
	printf("%s",text);
	int x;
	while(scanf("%d",&x)!=1){
		while(getchar()!='\n');
		printf("%s",text);
	}
	return x;
}

void funcAppendNode(){
	int x = inputInt("The val you want to append: ");
	appendNode(x);
	printf("Success!\n");
}

void funcDeleteNode(){
	int x = inputInt("The val you want to delete: ");
	int status = deleteNode(x);
	if(status==1){
		printf("Success!\n");
	}else if(status==-1){
		printf("Error! The element of %d is not found!\n", x);
	}
}

void funcInsertNode(){
	int y = inputInt("The val for the positon where is in front of this element: ");
	int x = inputInt("The new val you want to insert: ");
	int status = insertNode(x,y);
	if(status==1){
		printf("Success!\n");
	}else if(status==-1){
		printf("Error! The element of %d is not found!\n", y);
	}
}

void funcPrintfNode(){
	Node *p=list;
	if(list==NULL){
		printf("NULL\n");
		return;
	}
	printf("%d",p->data);
	for(p=p->next;p!=NULL;p=p->next){
		printf(" -> %d",p->data);
	}
	printf("\n");
}

void printMenu(){
	printf(" ----MENU-----\n");
	printf("[1] append node\n");
	printf("[2] delete node\n");
	printf("[3] insert node\n");
	printf("[4] printf node\n");
	printf("[0] exit\n");
}

int choiceFunc(){
	printf("Your choice: ");
	int x;
	while(scanf("%d",&x)!=1 || x>4 || x<0){
		printf("Your choice should be a integer and between 0 and 4.\n");
		while(getchar()!='\n');
		printf("Your choice: ");
	}
	return x;
}

int main(){
	printMenu();
	int choice;
	while((choice=choiceFunc())!=0){
		switch(choice){
			case 1:{
				funcAppendNode();
				break;
			}
			case 2:{
				funcDeleteNode();
				break;
			}
			case 3:{
				funcInsertNode();
				break;
			}
			case 4:{
				funcPrintfNode();
				break;
			}
			default:{
				break;
			}
		}
		printMenu();
	};
	printf("Bye!\n");
	return 0;
}



//typedef struct {
//	int year;
//	int month;
//	int day;
//} Date;
//
//typedef struct {
//	long long id;
//	char name[10];
//	char sex;
//	Date birth;
//	int score[4];
//} Student;
//
//typedef union {
//	int a;
//	char c;
//} TestUnion;
//
//void test(TestUnion a){
//	printf("%d\n",a);
//}
//
//int main(){
////	printf("%d\n",sizeof(Student));
//	TestUnion u1={0xFFFFFFFF};
//
//	printf("%d\n",u1);
//	u1.c='a';
//	printf("%x\n", u1 );
//	TestUnion u2={'a'};
//	printf("%d\n", u2 );
////	test(u2);
//
////	printf("%d\n",u1>u2);//fail
//	return 0;
//}
