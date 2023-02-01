#include <stdio.h>
#include <stdlib.h>
#include <time.h>

char *DB_SUITS[]={"Spades","Hearts","Clubs","Diamonds"};
char *DB_FACES[]={"A","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

typedef struct {
	char *suit;
	char *face;
}Card;

void initCard(Card cards[52]){
	int i,j;
	int k=0;
	for(i=0;i<4;i++){
		for(j=0;j<13;j++,k++){
			cards[k].suit=DB_SUITS[i];
			cards[k].face=DB_FACES[j];
		}	
	}
}

void upset(Card cards[52]){
	srand(time(NULL));
	int i,j;
	Card c;
	for(i=0;i<52;i++){
		j=rand() % 52;
		c.face=cards[i].face;
		c.suit=cards[i].suit;
		cards[i]=cards[j];
		cards[j]=c;
	}
}

void printCard(Card cards[52]){
	int i;
	for(i=0;i<52;i++){
		printf("[%d] %-8s %-5s\n",i+1,cards[i].suit,cards[i].face);
	}
}

int main(){
	Card cards[52];
	initCard(cards);
	upset(cards);
	printCard(cards);
	return 0;
}
