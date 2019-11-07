#include <iostream>
#include "LinkNodes.h"

LinkNodes* createLinkNodes(int data, const char* info)
{
	LinkNodes* link = new LinkNodes;
	link->data = data;
	link->info = info;
	link->next = NULL;
	return link;
}

void linkTwoNodes(LinkNodes* a, LinkNodes* b)
{
	a->next = b;
}

void printLink(LinkNodes* p, bool flag)
{
	std::cout << "start. " << std::endl;
	while (p!=NULL)
	{
		
		if (flag)
		{
			std::cout << p->data << ":" << p->info << std::endl;
		}
		else
		{
			std::cout << p->data << " ";
		}
		p = p->next;
	}
	std::cout << "\n.end" << std::endl;
}

int linkLength(LinkNodes* p)
{
	int length = 0;
	while (p != NULL)
	{
		length++;
		p = p->next;
	}
	return length;
}

//公共节点
LinkNodes* commonLinkNodes(LinkNodes* a, LinkNodes* b)
{
	int length = linkLength(a) - linkLength(b);
	if (length > 0)
	{
		while (a != NULL && length > 0)
		{
			a = a->next;
			length--;
		}
	}
	else
	{
		length = linkLength(b) - linkLength(a);
		while (b != NULL && length > 0)
		{
			b = b->next;
			length--;
		}
	}
	while (a != NULL && b != NULL && a != b)
	{
		a = a->next;
		b = b->next;
	}
	return a;
}

//反转链表
LinkNodes* reverseLink(LinkNodes* head)
{
	if (head == NULL||head->next == NULL)
	{
		return head;
	}
	LinkNodes* font = head;
	LinkNodes* p = head->next;
	head->next = NULL;
	LinkNodes* linkNext = NULL;
	while (p != NULL)
	{
		linkNext = p->next;
		p->next = font;
		font = p;
		p = linkNext;
	}
	return font;
}

//合并两个有序序列（升序）
LinkNodes* mergeList(LinkNodes* a, LinkNodes* b)
{
	if (a == NULL)
	{
		return b;
	}
	else if (b == NULL)
	{
		return a;
	}
	else
	{
		LinkNodes* p = NULL;
		if (a->data < b->data)
		{
			p = a;
			p->next = mergeList(a->next, b);
		}
		else
		{
			p = b;
			p->next = mergeList(a, b->next);
		}
		return p;
	}
}

void delLinkNode(LinkNodes* &p)
{
	delete p;
	p = NULL;
}
