#include <iostream>

using namespace std;

class Node
{
public:
	Node* next;
	Node(int value);
	~Node();
	void toPrint() {
		Node *node = this;
		while (node != nullptr) 
		{
			cout << node->value << " ";
			node = node->next;
		}
		cout << endl;
	}
	Node* mergeSort() {
		Node* head = this;
		if (head == nullptr)
		{
			return nullptr;
		}
		if (head->next == nullptr)
		{
			return head;
		}
		Node* midNode = head->getMiddle();
		return merge(head->mergeSort(), midNode->mergeSort());
	}
private:
	//合并有序链表
	Node* merge(Node* p1, Node* p2) {
		Node temp(-1);
		Node* p = &temp;
		while (p1 != nullptr && p2 != nullptr)
		{
			if (p1->value > p2->value)
			{
				p->next = p1;
				p1 = p1->next;
			}
			else
			{
				p->next = p2;
				p2 = p2->next;
			}
			p = p->next;
		}
		if (p1 != nullptr) {
			p->next = p1;
		}
		if (p2 != nullptr)
		{
			p->next = p2;
		}
		return temp.next;
	}
	//将node分割两半并返回mid
	Node* getMiddle() {
		Node* head = this;
		Node* slow = head;
		Node* quick = head;
		while (quick->next != nullptr && quick->next->next != nullptr)
		{
			quick = quick->next->next;
			slow = slow->next;
		}
		Node* midNode = slow->next;
		slow->next = nullptr;
		return midNode;
	}
	int value;
};

Node::Node(int value)
{
	this->value = value;
	this->next = nullptr;
}

Node::~Node()
{
}

int main() {
	Node* head = new Node(3);
	head->next = new Node(2);
	head->next->next = new Node(6);
	head->mergeSort()->toPrint();

	delete head->next->next;
	delete head->next;
	delete head;
	return 0;
}