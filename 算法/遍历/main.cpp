#include <iostream>
#include <queue>
using namespace std;
class BinaryTree
{
public:
	BinaryTree* left;
	BinaryTree* right;
	BinaryTree(int value);
	~BinaryTree();
	void preTraversal();//前序遍历
	void midTraversal();//中序遍历
	void aftTraversal();//后序遍历
	void levelTraversal();//层次遍历
private:
	int value;
};

BinaryTree::BinaryTree(int value)
{
	this->value = value;
	this->left = nullptr;
	this->right = nullptr;
}

BinaryTree::~BinaryTree()
{
}

void BinaryTree::preTraversal()
{
	BinaryTree* head = this;
	cout << head->value << " ";
	if (head->left != nullptr)
	{
		head->left->preTraversal();
	}
	if (head->right != nullptr)
	{
		head->right->preTraversal();
	}
}
void BinaryTree::midTraversal()
{
	BinaryTree* head = this;
	if (head->left != nullptr)
	{
		head->left->midTraversal();
	}
	cout << head->value << " ";
	if (head->right != nullptr)
	{
		head->right->midTraversal();
	}
}
void BinaryTree::aftTraversal()
{
	BinaryTree* head = this;
	if (head->left != nullptr)
	{
		head->left->aftTraversal();
	}
	if (head->right != nullptr)
	{
		head->right->aftTraversal();
	}
	cout << head->value << " ";
}
void BinaryTree::levelTraversal()
{
	queue<BinaryTree*> q;
	BinaryTree* head = this;
	BinaryTree* last = head;//当前层次结尾
	BinaryTree* nlast = nullptr;//下一行结尾
	q.push(head);
	nlast = head;
	while (!q.empty())
	{
		BinaryTree* tree = q.front();
		q.pop();
		if (tree->left != nullptr)
		{
			q.push(tree->left);
			nlast = tree->left;
		}
		if (tree->right != nullptr)
		{
			q.push(tree->right);
			nlast = tree->right;
		}
		if (last == tree)
		{
			cout << tree->value << endl;
			last = nlast;
		}
		else
		{
			cout << tree->value << " ";
		}
	}
}
int main() {
	BinaryTree* head = new BinaryTree(1);
	head->left = new BinaryTree(2);
	head->left->left = new BinaryTree(4);
	head->left->right = new BinaryTree(5);
	head->right = new BinaryTree(3);
	head->right->left = new BinaryTree(6);

	head->levelTraversal();
	return 0;
}