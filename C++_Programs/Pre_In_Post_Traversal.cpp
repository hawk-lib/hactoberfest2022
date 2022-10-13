#include<bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    Node*left;
    Node*right;
    Node(int val){
        left = right = NULL;
    }
};

Node*newNode(int val){
    Node*temp = new Node(val);
    temp->data = val;
    temp->left = temp->right = NULL;
    return temp;
}


void PreInPost(Node*root, vector<int>&pre, vector<int>&in, vector<int>&post){
    stack<pair<Node*,int>> s;
    s.push({root,1});
    if(root==NULL)
    return;

    while(!s.empty()){

        //traversing the entire stack to store the addresses of the node in (it)
        auto it = s.top();
        s.pop();

        // this is part of pre
        // increment by 1
        // if left exist push the left

        if(it.second==1){
            pre.push_back(it.first->data);
            it.second++;
            s.push(it);
            if(it.first->left!=NULL ){
                s.push({it.first->left,1});
            }
        }

        // This is part of in
        // increment by 1
        // if right exist push the right

        else if(it.second==2){
            in.push_back(it.first->data);
            it.second++;
            s.push(it);
            if(it.first->right!=NULL){
                s.push({it.first->right, 1});
            }
        }
        else{
            post.push_back(it.first->data);
        }
    }
}

int main(){
    Node*root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(5);
    root->left->left = newNode(3);
    root->left->right = newNode(4);
    root->right->left = newNode(6);
    root->right->right = newNode(7);

        vector<int> pre,in,post;
        PreInPost(root,pre,in,post);
    // vector<int> pre = PreInPost(root);
    // vector<int>in = PreInPost(root);
    // vector<int>post = PreInPost(root);

    cout<<"Preorder Traversal :";
    for(auto it: pre){
        cout<<it<<" ";
    }
    cout<<endl;
    cout<<"Inorder Traversal :";
    for(auto it: in){
        cout<<it<<" ";
    }
    cout<<endl;
    cout<<"Postorder Traversal :";
    for(auto it : post){
        cout<<it<<" ";
    }
}