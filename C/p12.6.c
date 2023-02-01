#include <stdio.h>

typedef struct node{
	int data;
	struct node *next;
}Node;

void push(Node **s, int v){
	Node *n=(Node *)malloc(sizeof(Node));
	n->data=v;
	n->next=NULL;
	if(*s==NULL){
		*s=n;
	}else{
		n->next=(*s);
		*s=n;
	}
}

//1success; 0fail
int pop(Node **s,int *pv){
	if(*s==NULL){ return -1; }
	*pv=(*s)->data;
	Node *p = *s;
	*s=p->next;
	free(p);
}

void printStack(Node *s){
	while(s!=NULL){
		printf(" %d",s->data);
		s=s->next;
	}
	printf("\n");
}

int main(){
	Node *stack=NULL;
	int val;
	push(&stack,1);
	push(&stack,2);
	pop(&stack,&val);
	printf(">>>>>>>>%d\n",val);
	pop(&stack,&val);
	printf(">>>>>>>>%d\n",val);
	push(&stack,3);
	printStack(stack);
	return 0;
}
