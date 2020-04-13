#include <iostream>
#include <cstring> 
#include <queue>
#include <set>
using namespace std;

const char* start = "012345678";
const char* target = "087654321";


struct cmp {
	bool operator () (char* a, char* b) const {
		return strcmp(a,b) > 0;
	}
};
set<char*, cmp>allState; //自定义排序函数构造set

class StateAndLevel
{
public:
	StateAndLevel(const char* state, int level, int pos0);
	~StateAndLevel();
	const char* state;
	int level;
	int pos0;
};

StateAndLevel::StateAndLevel(const char* state, int level, int pos0)
	: state(state),level(level),pos0(pos0)
{

}

StateAndLevel::~StateAndLevel()
{
	if (state != nullptr)
	{
		delete state;
	}
}

void swap(char* state, int pos, int newPos)
{
	char t = state[pos];
	state[pos] = state[newPos];
	state[newPos] = t;
}

void add(queue<StateAndLevel*> &q, char* new_state, int pos0, int newPos, int level) {
	char* str = new char[10];
	strcpy_s(str, strlen(new_state) + 1, new_state);
	swap(str, pos0, newPos);
	if (allState.find(str) == allState.end())//没有
	{
		allState.insert(str);
		q.push(new StateAndLevel(str, level + 1, newPos));
	}
	else
	{
		delete[] str;
	}
}

int main()
{
	queue<StateAndLevel*> q;
	q.push(new StateAndLevel(start, 0, 0));
	while (!q.empty())
	{
		StateAndLevel* sal = q.front();q.pop();
		char* state = const_cast<char*>(sal->state);
		int level = sal->level;
		int pos0 = sal->pos0;
		//cout << state << endl;
		if (strcmp(state, target) == 0)
		{
			cout << level << endl;

			//break;
			//break;
		}

		int pos = (pos0 + 1 + 9) % 9;//右一
		add(q, state, pos0, pos, level);
		pos = (pos0 + 2 + 9) % 9;//右二
		add(q, state, pos0, pos, level);
		pos = (pos0 - 1 + 9) % 9;//左一
		add(q, state, pos0, pos, level);
		pos = (pos0 - 2 + 9) % 9;//左二
		add(q, state, pos0, pos, level);
	}
	cout << "查找了" << allState.size() << "种状态" << endl;
	return 0;
}
