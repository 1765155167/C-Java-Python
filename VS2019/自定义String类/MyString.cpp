#include "MyString.h"

MyString::MyString()
{
	this->buf = NULL;
	this->len = 0;
}

MyString::MyString(const char* data)
{
	size_t len = strlen(data);
	this->buf = new char[len + 1];
	for (size_t i = 0; i < len; i++)
	{
		this->buf[i] = data[i];
	}
	*(this->buf + len) = '\0';
	this->len = len;
}

MyString::MyString(const char ch)
{
	this->len = 2;
	this->buf = new char[1];
	*(this->buf + 0) = ch;
	*(this->buf + 1) = '\0';
}


MyString::MyString(const MyString& another)
{
	this->len = another.len;
	this->buf = new char[this->len + 1];
	for (size_t i = 0; i < this->len; i++)
	{
		*(this->buf + i) = *(another.buf + i);
	}
	*(this->buf + len) = '\0';
}

MyString& MyString::operator=(const MyString& another)
{
	if (this->buf != NULL)
	{
		delete[] this->buf;
		this->buf = NULL;
	}
	this->buf = new char[another.len + 1];
	for (size_t i = 0; i < another.len; i++)
	{
		this->buf[i] = another.buf[i];
	}
	this->buf[another.len] = '\0';
	this->len = another.len;
	return *this;
}

#if 1
MyString MyString::operator+(const MyString& another)
{
	MyString temp;
	size_t len = this->len + another.len;
	temp.buf = new char[len + 1];
	for (size_t i = 0; i < this->len; i++)
	{
		*(temp.buf + i) = *(this->buf + i);
	}
	for (size_t i = 0; i < another.len; i++)
	{
		*(temp.buf + this->len + i) = *(another.buf + i);
	}
	*(temp.buf + len) = '\0';
	temp.len = len;
	return temp;
}
#endif // 0

bool MyString::operator==(const MyString& another)
{
	bool ret = true;
	if (this->len != another.len)
	{
		std::cout << "长度不相等" << std::endl;
		return false;
	}
	for (size_t i = 0; i < another.len; i++)
	{
		if (*(this->buf + i) != *(another.buf + i))
		{
			std::cout << *(this->buf + i) << ":" 
				<< *(another.buf + i) << ":" << i << std::endl;
			ret = false;
			break;
		}
	}
	return ret;
}

bool MyString::operator!=(const MyString& another)
{
	bool ret = false;
	if (this->len != another.len)
	{
		return true;
	}
	for (size_t i = 0; i < another.len; i++)
	{
		if (*(this->buf + i) != *(another.buf + i))
		{
			ret = true;
			break;
		}
	}
	return ret;
}

char& MyString::operator[](size_t num) const
{
	return *(this->buf + num);
}

const char* MyString::to_str() const
{
	return this->buf;
}

MyString::~MyString()
{
	if (this->buf != NULL)
	{
		delete[] this->buf;
		this->buf = NULL;
	}
}

const size_t MyString::length() const
{
	return this->len;
}

std::ostream& operator<<(std::ostream& os, MyString& another)
{
	if (another.buf != NULL)
	{
		os << another.buf;
	}
	return os;
}

std::istream& operator>>(std::istream& is, MyString& another)
{
	if (another.buf != NULL)
	{
		delete[] another.buf;
	}
	another.buf = new char[255];
	is >> another.buf;
	another.len = strlen(another.buf);
	another.buf[another.len] = '\0';
	return is;
}

