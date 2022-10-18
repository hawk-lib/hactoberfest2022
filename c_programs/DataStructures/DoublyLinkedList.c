#include <stdio.h>
#include <stdlib.h>
struct Node{
	int data;
	struct Node *next;
	struct Node *prev;
}*head,*temp,*tail;

typedef struct Node node;
void insert_begin(int data){
	node *newNode=(node*)malloc(sizeof(node));
	newNode->data=data;
	newNode->next=NULL;
	newNode->prev=NULL;
	if(head==NULL){
		head=tail=newNode;
	}else{
		newNode->next=head;
		head->prev=newNode;
		head=newNode;
	}
	printf("\n%d is inserted at the beginning\n",data);
}

void insert_middle(int data,int loc){
	node *newNode=(node*)malloc(sizeof(node));
	newNode->data=data;
	newNode->next=NULL;
	newNode->prev=NULL;
	if(head==NULL){
		head=tail=newNode;
	}else{
		temp=head;
		int i;
		for(i=1;i<=loc-2;i++){
			temp=temp->next;
		}
		newNode->next=temp->next;
		temp->next->prev=newNode;
		newNode->prev=temp;
		temp->next=newNode;
	}
	printf("\n%d is inserted at location %d\n",data,loc);
}

void insert_end(int data){
	node *newNode=(node*)malloc(sizeof(node));
	newNode->data=data;
	newNode->next=NULL;
	newNode->prev=NULL;
	if(head==NULL){
		head=tail=newNode;
	}else{
		tail->next=newNode;
		newNode->prev=tail;
		tail=newNode;
	}
	printf("\n%d is inserted at the end\n",data);
}

void del_begin(){
	temp=head;
	head=head->next;
	free(temp);
	printf("\nElement at the beginning is deleted!\n");
}

void del_middle(int loc){
	temp=head;
	int i;
    for(i = 1; i < loc; i++){  
        temp = temp->next;  
    }  
    if(temp == head) {  
        head = temp->next;  
    }  
    else if(temp == tail) {  
        tail = tail->prev;  
    }  
    else {  
        temp->prev->next = temp->next;  
        temp->next->prev = temp->prev;  
    } 
	free(temp);
	printf("\nElement at the location %d is deleted!\n",loc);
}

void del_end(){
	temp=tail;
	tail=tail->prev;
	tail->next=NULL;
	free(temp);
	printf("\nElement at the end is deleted!\n");
}

void display_begin(){
	temp=head;
	printf("\n");
	while(temp!=NULL){
		printf("%d ",temp->data);
		temp=temp->next;
	}printf("\n");
}

void display_end(){
	temp=tail;
	printf("\n");
	while(temp!=NULL){
		printf("%d ",temp->data);
		temp=temp->prev;
	}printf("\n");
}

void search(int data){
	temp=head;
	int i=0;
	while(temp!=NULL){
		i++;
		if(temp->data==data){
			printf("\n%d found at location %d\n",data,i);
		}
		temp=temp->next;
	}
}

int main(){
    printf("Doubly Linked List\n");
    int choice;
    while(1){
        printf("\n1. Insert Node \n2. Delete Node\n3. Display\n4. Search\n5. Exit\n");
        printf("\nYour choice: ");
        scanf("%d",&choice);
        int choice2, val, loc;
        switch(choice){
            case 1: printf("\nEnter the value to be inserted: ");
                    scanf("%d", &val);
                    printf("\nWhere do you want to insert?\n1. At the beginning\n2. At the middle\n3. At the end\n\nYour choice: ");
                    scanf("%d", &choice2);
                    switch(choice2){
                        case 1: insert_begin(val);
                                break;
                        case 2: printf("Location to be inserted: ");
                                scanf("%d", &loc);
                                insert_middle(val, loc);
                                break;
                        case 3: insert_end(val);
                                break; 
                    }
                    break;

            case 2: printf("\nWhere do you want to delete?\n1. At the beginning\n2. At the middle\n3. At the end\n\nYour choice: ");
                    scanf("%d", &choice2);
                    switch(choice2){
                        case 1: del_begin();
                                break;
                        case 2: printf("Location to be deleted: ");
                                scanf("%d", &loc);
                                del_middle(loc);
                                break;
                        case 3: del_end();
                                break; 
                    }
                    break;

            case 3: printf("\nHow do you want to traverse?\n1.Start to end\n2.End to start\n\nYour choice: ");
                    scanf("%d",&choice2);
					switch(choice2){
                    	case 1:display_begin();
                    	       break;
                    	case 2:display_end();
                    	       break;
					}
					break;

            case 4: printf("\nWhich element do you want to search: ");
                    scanf("%d", &val);
                    search(val);
                    break;

            default : exit(0);
                
        }
        
    }
}