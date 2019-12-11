#pragma once

// 小链表节点
typedef struct NODE
{
	struct NODE* next;	// 指向后继节点的指针
}ListNode;

typedef struct LINKLIST
{
	ListNode head;
	int size;
}LinkList;

typedef void(*PRINTLIST)(ListNode*);

// 初始化，建立一个空的线性表L。
LinkList* InitList();
// 在线性表L中的第pos个位置插入新元素e
void ListInsert(LinkList* L, int pos, ListNode* data);
// 删除线性表L中的第pos个位置元素，并用e返回其值
void ListDelete(LinkList* L, int pos);
//查找
int ListFind(LinkList* L, ListNode* data);
// 返回线性表L的元素个数
int ListLength(LinkList* L);
//打印
void ListPrint(LinkList* L, PRINTLIST print);
//释放
void ListFree(LinkList* L);