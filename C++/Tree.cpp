#include <stack>
#include <queue>
#include <iostream>

using namespace std;

typedef struct BinaryTree
{
	int val;
	BinaryTree* rTree;
	BinaryTree* lTree;
}BinaryTree;

void createBinaryTree(BinaryTree* &tree)
{
	int data;
	cin >> data;
	
	if (data == 0)
	{
		tree = NULL;
	} else {
		tree = new BinaryTree;
		tree->val = data;
		createBinaryTree(tree->lTree);
		createBinaryTree(tree->rTree);
	}
}

/*
 * 前序遍历递归
 **/
void preTraversalRec(BinaryTree * root)
{
	if(root == NULL)
	{
		return ;
	}
	cout << root->val << " ";
	preTraversalRec(root->lTree);
	preTraversalRec(root->rTree);
}
/*
 * 中序遍历递归
 **/
void midTraversalRec(BinaryTree * root)
{
	if(root == NULL)
	{
		return ;
	}
	midTraversalRec(root->lTree);
	cout << root->val << " ";
	midTraversalRec(root->rTree);
}
/*
 * 前序遍历非递归
 **/
void preTraversal(BinaryTree * root)
{
	if(root == NULL)
	{
		return ;
	}
	stack<BinaryTree *> stk;
	stk.push(root);
	while(!stk.empty())
	{
		BinaryTree* temp = stk.top();
		stk.pop();
		cout << temp->val << " ";
		if(temp->rTree != NULL)
		{
			stk.push(temp->rTree);
		}
		
		if(temp->lTree != NULL)
		{
			stk.push(temp->lTree);	
		}
	}
}

/*
 * 层次遍历非递归
 **/
void levTraversal(BinaryTree * root)
{
	if(root == NULL)
	{
		return ;
	}
	queue<BinaryTree *> que;
	que.push(root);
	while(!que.empty())
	{
		BinaryTree* temp = que.front();
		que.pop();
		cout << temp->val << " ";
		if(temp->lTree != NULL)
		{
			que.push(temp->lTree);	
		}
		if(temp->rTree != NULL)
		{
			que.push(temp->rTree);
		}
	}
}

/*求树的深度*/
int deepTree(BinaryTree * tree)
{
	int rDeep = 0, lDeep = 0;
	if(tree == NULL)
	{
		return 0;
	}
	if(tree->rTree != NULL)
	{
		rDeep = deepTree(tree->rTree);
	}
	if(tree->lTree != NULL)
	{
		lDeep = deepTree(tree->lTree);
	}
	return rDeep > lDeep ? rDeep + 1 : lDeep + 1;
}

int main()
{
	int data = 0;
	BinaryTree * root = new BinaryTree;
	cin >> data;
	root->val = data;
	if(root->val != 0)
	{
		createBinaryTree(root->lTree);
		createBinaryTree(root->rTree);
	}
	midTraversalRec(root);
	cout << endl;
	preTraversalRec(root);
	cout << endl;
	preTraversal(root);
	cout << endl;
	levTraversal(root);
	cout << endl;
	cout << "Deep: " << deepTree(root) << endl;
	return 0;
}
