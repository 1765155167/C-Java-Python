# STL
## vector
- 单口数组,在尾部插入与删除元素效率高,一段连续内存空间
- 支持遍历与随机访问 []越界出错 at()越界返回异常
- push_back() pop_back()
- insert(pop, elem) pop位置插入额elem元素
- erase(pop) 位置删除 erase(start, end) 区间删除 erase() 清空
- resize() 改变容器中元素个数
- reserve() 改变容器容量
- front() 返回头元素引用
- back() 返回尾元素引用
## deque
- 双口容器,在尾部与头部插入删除元素效率高,分段连续内存空间
- 支持遍历与随机访问 []越界出错 at()越界返回异常
- push_back() pop_back() push_front() push_front()
- front() 返回头元素引用
- back() 返回尾元素引用
- empty() size() swap()
## stack (后进先出)
- 栈,单口容器,不支持遍历,不支持随机访问
- push() 入栈
- pop() 出栈 [没有返回值]
- top() 返回栈顶元素
- empty() size() swap()
## queue (先进先出)
- 队列,双口容器,尾部插入,头部删除,不支持随机访问,不能遍历
- push() pop() 
- front() 返回队列头引用
- back() 返回队列尾引用
## list
- 双链表,可以遍历,[] at(),不支持随机访问,
- 对比数组插入删除元素效率高,
- 重载了++了--运算符来指向下/上一个元素
- push_front()头部插入 pop_front()头部删除
- push_back()尾部插入 pop_back()尾部删除
- front()头引用
- back()尾引用
- next:下一个节点 prev:上一个结点
- begin() end() insert()
## set 
- 红黑树,支持遍历,不支持随机访问
- insert(elem) 插入元素后会自动排序
- erase(elem) erase(pop) erase(start,end)
- 没有相同元素
- find()找到返回位置、找不到返回end()
- lower_bound()大于等于
- upper_bound()大于
- equal_range()返回pair<lower_bound(),upper_bound()> 
```
//仿函数
class mycompare {
public:
	bool operator()(const int a,const int b) const
	{
		return a > b;
	}
};
std::set<int, mycompare> s;//利用仿函数更改为降序排序
std::set<Person, mycompare> s;//放入类对象时需要利用仿函数声明排序规则
```
## map
- 红黑树 一个元素为一个队组pair 
- pair.frist 键
- pair.second 值