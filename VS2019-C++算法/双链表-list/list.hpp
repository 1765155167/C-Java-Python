#pragma once
#include <iostream>

template<class T>
struct DoubleList
{
	T data;
	struct DoubleList<T>* next;// 下一个节点
	struct DoubleList<T>* prev;// 上一个结点
};

//带头节点的双链表
template<class T>
class list
{
public:
	list();
	~list();
	//重载了++了--运算符来指向下/上一个元素
	void push_front(T elem);
	void push_back(T elem);
	void pop_front();
	void pop_back();
	T& Front();//front()头引用
	T& Back();//back()尾引用
	bool empty();
	int size();
	void sort();
	void sort(bool(*compare)(T a, T b));
	void traversal();//遍历链表
	void traversal_ptr();
	//next:下一个节点 prev:上一个结点
	bool find(T elem);

private:
	struct DoubleList<T>* head;
	struct DoubleList<T>* back;
	int len;
};

template<class T>
inline list<T>::list()
{
	this->head = new struct DoubleList<T>;
	this->back = new struct DoubleList<T>;
	this->head->data = static_cast<T>(0);
	this->head->prev = NULL;
	this->head->next = this->back;
	this->back->data = static_cast<T>(0);
	this->back->next = NULL;
	this->back->prev = this->head;
	this->len = 0;
}

template<class T>
inline list<T>::~list()
{
	struct DoubleList<T>* p = this->head->next;
	while (p != this->back)
	{
		struct DoubleList<T>* q = p;
		p = p->next;
		delete q;
	}
	delete this->back;
}

template<class T>
inline void list<T>::push_front(T elem)//头插入
{
	struct DoubleList<T>* newList = new struct DoubleList<T>;
	newList->data = elem;

	newList->prev = this->head;
	newList->next = head->next;
	head->next->prev = newList;
	head->next = newList;

	this->len++;
}

template<class T>
inline void list<T>::push_back(T elem)//尾插入
{
	struct DoubleList<T>* newList = new struct DoubleList<T>;
	newList->data = elem;

	newList->next = this->back;
	newList->prev = this->back->prev;
	this->back->prev->next = newList;
	this->back->prev = newList;

	this->len++;
}

template<class T>
inline void list<T>::pop_front()
{
	if (len > 0)
	{
		struct DoubleList<T>* p = this->head->next;
		this->head->next = p->next;
		p->next->prev = head;
		delete p;
		this->len--;
	}
	else
	{
		throw "容器为空";
	}
}

template<class T>
inline void list<T>::pop_back()
{
	if (len > 0)
	{
		struct DoubleList<T>* p = this->back->prev;
		this->back->prev = p->prev;
		p->prev->next = this->back;
		delete p;
		this->len--;
	}
	else
	{
		throw "容器为空";
	}
}

template<class T>
inline T& list<T>::Front()
{
	if (this->len > 0)
	{
		return this->head->next->data;
	}
	else
	{
		throw "容器为空";
	}
}

template<class T>
inline T& list<T>::Back()
{
	if (this->len > 0)
	{
		return this->back->prev->data;
	}
	else
	{
		throw "容器为空";
	}
}

template<class T>
inline bool list<T>::empty()
{
	if (this->len == 0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

template<class T>
inline int list<T>::size()
{
	return this->len;
}

template<class T>
inline void list<T>::traversal()
{
	struct DoubleList<T>* p = this->head->next;
	for (int i = 0; i < this->len; i++)
	{
		std::cout << p->data << " ";
		p = p->next;
	}
	std::cout << std::endl;
}

template<class T>
inline void list<T>::traversal_ptr()
{
	struct DoubleList<T>* p = this->head->next;
	for (int i = 0; i < this->len; i++)
	{
		std::cout << *(p->data);
		p = p->next;
	}
}

template<class T>
inline void list<T>::sort()//升序 选择排序
{
	struct DoubleList<T>* p = this->head->next;
	for (int i = 0; i < this->len - 1; i++)
	{
		struct DoubleList<T>* q = p;
		struct DoubleList<T>* min = p;
		for (int j = i ; j < this->len; j++)
		{
			if (min->data > q->data)
			{
				min = q;
			}
			q = q->next;
		}
		if (min != p)
		{
			std::swap(min->data, p->data);
		}
		p = p->next;
	}
}

template<class T>
inline void list<T>::sort(bool(*compare)(T a, T b))
{
	struct DoubleList<T>* p = this->head->next;
	for (int i = 0; i < this->len; i++)
	{
		struct DoubleList<T>* q = p;
		struct DoubleList<T>* min = p;
		for (int j = i; j < this->len; j++)
		{
			//if (min->data > q->data)
			if(!compare(min->data, q->data))
			{
				min = q;
			}
			q = q->next;
		}
		if (min != p)
		{
			std::swap(min->data, p->data);
		}
		p = p->next;
	}
}

template<class T>
inline bool list<T>::find(T elem)
{
	if (this->len > 0)
	{
		struct DoubleList<T>* p = head->next;
		while (p != this->back)
		{
			if (p->data == elem)
			{
				return true;
			}
			p = p->next;
		}
	}
	return false;
}
