#include "CircleList.h"

CircleList::CircleList()
{
	this->head.next = &(this->head);
	this->len = 0;
}

CircleList::~CircleList()
{
}

void CircleList::push_pos(Node* data, int pos)
{
	if (data == NULL) {
		return;
	}
	if (pos < 0 || pos > this->len)
	{
		pos = len;
	}
	//查找pos位置
	Node* p = &(this->head);
	for (int i = 0; i < pos; i++)
	{
		p = p->next;
	}
	data->next = p->next;
	p->next = data;
	this->len++;
}

//遍历
void CircleList::traversal(PRINTCIRCLELIST print)
{
	Node* p = this->head.next;
	for (int i = 0; i < this->len; i++)
	{
		if (p == &this->head)
		{
			p = this->head.next;
			std::cout << "---------------------->" << std::endl;
		}
		print(p);
		p = p->next;
	}
}

void CircleList::remove(Node* data, COMPAIR compair)
{
	Node* p = &(this->head);//要删除节点的前一个节点
	for (int i = 0; i < this->len; i++)
	{
		if (compair(p->next, data))
		{
			p->next = p->next->next;
			this->len--;
			return ;
		}
		p = p->next;
	}
}

int CircleList::size()
{
	return this->len;
}

bool CircleList::empty()
{
	return this->len == 0;
}
