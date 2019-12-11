#pragma once
template<class T>
class BinaryTree
{
private:
	static int sum;
	T data;
	BinaryTree<T>* lChild;
	BinaryTree<T>* rChild;
public:
	BinaryTree(/* args */);
	BinaryTree(T data);
	~BinaryTree();
	void setRightChild(BinaryTree<T>* rChild);
	void setLeftChild(BinaryTree<T>* lChild);
	void setData(T data);
	BinaryTree<T>* getRightChild() const;
	BinaryTree<T>* getLeftChild() const;
	T getData() const;
	static int getSum();
};
int BinaryTree<int>::sum = 0;
