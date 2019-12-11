#pragma once
#include <iostream>

typedef struct NODE {
	struct NODE* next;
}Node;

class Stack
{
public:
	Stack();
	void push(Node* data);
	void pop();
	Node*& top();
	bool empty();
	int size();
	~Stack();
private:
	Node head;
	int len;
};

