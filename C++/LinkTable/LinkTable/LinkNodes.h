#pragma once

typedef struct LinkNodes
{
	int data;
	const char* info;
	LinkNodes* next;
}LinkNodes;

LinkNodes* createLinkNodes(int data, const char* info);
void linkTwoNodes(LinkNodes* a, LinkNodes* b);
void printLink(LinkNodes* p, bool flag);
int linkLength(LinkNodes* p);
void delLinkNode(LinkNodes* &p);
LinkNodes* commonLinkNodes(LinkNodes* a, LinkNodes* b);
LinkNodes* reverseLink(LinkNodes* head);
LinkNodes* mergeList(LinkNodes* a, LinkNodes* b);