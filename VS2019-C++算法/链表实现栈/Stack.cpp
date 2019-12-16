#include "Stack.h"

Stack::Stack()
{
	this->head.next = NULL;
	this->len = 0;
}

void Stack::push(Node* data)
{
	data->next = this->head.next;
	this->head.next = data;
	this->len++;
}

void Stack::pop()
{
	this->head.next = this->head.next->next;
	this->len--;
}

Node*& Stack::top()
{
	return this->head.next;
}

bool Stack::empty()
{
	return this->len == 0;
}

int Stack::size()
{
	return this->len;
}

Stack::~Stack()
{

}
