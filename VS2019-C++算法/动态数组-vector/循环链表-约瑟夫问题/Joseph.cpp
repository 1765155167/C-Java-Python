#include "Joseph.h"

Joseph::Joseph()
{
}

Joseph::~Joseph()
{
}

void Joseph::JosephProblem(int n, COMPAIR compair, PRINTCIRCLELIST printf)
{
	int index = 1;
	Node* p = this->head.next;
	while (!this->empty())
	{
		if (p == &this->head)
		{
			p = this->head.next;
		}
		if (index == n)
		{
			Node* temp = p->next;
			printf(p);
			this->remove(p, compair);
			p = temp;
			index = 1;
			continue;
		}
		p = p->next;
		index++;
	}
}
