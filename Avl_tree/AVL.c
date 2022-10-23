#include <stdio.h>
#include <stdlib.h>


struct Node {
  int key;
  struct Node *left;
  struct Node *right;
  int height;
};

int max(int a, int b);

// Calculate height
int height(struct Node *N) {
  if (N == NULL)
    return 0;
  return N->height;
}

int max(int a, int b) {
  return (a > b) ? a : b;
}

// Create a node
struct Node *newNode(int key) {
  struct Node *node = (struct Node *)
    malloc(sizeof(struct Node));
  node->key = key;
  node->left = NULL;
  node->right = NULL;
  node->height = 1;
  return (node);
}

// Right rotate
struct Node *rightRotate(struct Node *y) {
  struct Node *x = y->left;
  struct Node *T2 = x->right;

  x->right = y;
  y->left = T2;

  y->height = max(height(y->left), height(y->right)) + 1;
  x->height = max(height(x->left), height(x->right)) + 1;

  return x;
}

// Left rotate
struct Node *leftRotate(struct Node *x) {
  struct Node *y = x->right;
  struct Node *T2 = y->left;

  y->left = x;
  x->right = T2;

  x->height = max(height(x->left), height(x->right)) + 1;
  y->height = max(height(y->left), height(y->right)) + 1;

  return y;
}

// Get the balance factor
int getBalance(struct Node *N) {
  if (N == NULL)
    return 0;
  return height(N->left) - height(N->right);
}

// Insert node
struct Node *insertNode(struct Node *node, int key) {
  // Find the correct position to insertNode the node and insertNode it
  if (node == NULL)
    return (newNode(key));

  if (key < node->key)
    node->left = insertNode(node->left, key);
  else if (key > node->key)
    node->right = insertNode(node->right, key);
  else
    return node;

  // Update the balance factor of each node and
  // Balance the tree
  node->height = 1 + max(height(node->left),
               height(node->right));

  int balance = getBalance(node);
 /* if(balance>=-1 && balance<=1)
  {
    printf("NO ROTATION\n");
  }*/
  if (balance > 1 && key < node->left->key){
    printf("\n                        RR rotation,Imbalance at : %d\n\n",node->key);
    return rightRotate(node);
  }

  if (balance < -1 && key > node->right->key)
  {
    printf("\n                        LL rotation,Imbalance at : %d\n\n",node->key);
    return leftRotate(node);
  }

  if (balance > 1 && key > node->left->key) {
    printf("\n                        LR rotation,Imbalance at : %d\n\n",node->key);
    node->left = leftRotate(node->left);
    return rightRotate(node);
  }

  if (balance < -1 && key < node->right->key) {
    printf("\n                        RL rotation,Imbalance at : %d\n\n",node->key);
    node->right = rightRotate(node->right);
    return leftRotate(node);
  }
  

  return node;
}

struct Node *minValueNode(struct Node *node) {
  struct Node *current = node;

  while (current->left != NULL)
    current = current->left;

  return current;
}

// Delete a nodes
struct Node *deleteNode(struct Node *root, int key) {
  // Find the node and delete it
  if (root == NULL)
    return root;

  if (key < root->key)
    root->left = deleteNode(root->left, key);

  else if (key > root->key)
    root->right = deleteNode(root->right, key);

  else {
    if ((root->left == NULL) || (root->right == NULL)) {
      struct Node *temp = root->left ? root->left : root->right;

      if (temp == NULL) {
        temp = root;
        root = NULL;
      } else
        *root = *temp;
      free(temp);
    } else {
      struct Node *temp = minValueNode(root->right);

      root->key = temp->key;

      root->right = deleteNode(root->right, temp->key);
    }
  }

  if (root == NULL)
    return root;

  // Update the balance factor of each node and
  // balance the tree
  root->height = 1 + max(height(root->left),
               height(root->right));

  int balance = getBalance(root);
  
  if (balance > 1 && getBalance(root->left) >= 0)
  {
    return rightRotate(root);
  }

  if (balance > 1 && getBalance(root->left) < 0)
   {
    root->left = leftRotate(root->left);
    return rightRotate(root);
   }

  if (balance < -1 && getBalance(root->right) <= 0)
  {
    return leftRotate(root);
  }

  if (balance < -1 && getBalance(root->right) > 0)
   {
    root->right = rightRotate(root->right);
    return leftRotate(root);
   }

  return root;
}

// Print the tree
void printPreOrder(struct Node *root) {
  if (root != NULL) {
    printf("%d ", root->key);
    printPreOrder(root->left);
    printPreOrder(root->right);
  }
}


void inorder(struct Node* no)
{
    if(no==NULL)
    {
        return;
    }
    
    inorder(no->left);

    printf("%d ", no->key);

    inorder(no->right);
}



int main() 
{
    printf("------------------------------------Ques 1---------------------------------------------\n");
    printf("---------------------------------------------------------------------------------------\n");
  struct Node *root = NULL;
  printf("                                   insert 12 \n");
  root = insertNode(root, 12);
  printf("                                   insert 14\n");
  root = insertNode(root, 14);
  printf("                                   insert 15\n");
  root = insertNode(root, 15);
  printf("                                   insert 17\n");
  root = insertNode(root, 17);
  printf("                                   insert 3\n");
  root = insertNode(root, 3);
  printf("                                   insert 4\n");
  root = insertNode(root, 4);
  printf("                                   insert 9\n");
  root = insertNode(root, 9);
  printf("                                   insert 10\n");
  root = insertNode(root, 10);
  printf("                                   insert 20\n");
  root = insertNode(root, 20);

  printf("---------------------------------------------------------------------------------------\n");
   
  printf("                             Inorder of the tree\n");
  printf("\n                           ");
  inorder(root);

  printf("\n\n");
printf("---------------------------------------------------------------------------------------\n");
printf("------------------------------------Ques 2---------------------------------------------\n");
printf("---------------------------------------------------------------------------------------\n");

for(int i=0;i<9;i++)
{

printf("\n                           After deletion of : %d \n",root->key);
 root = deleteNode(root, root->key);

  printf("\n                            ");
  printPreOrder(root);
  printf("\n");
}
  
  printf("---------------------------------------------------------------------------------------\n");
  printf("---------------------------------------------------------------------------------------\n");

  return 0;
}