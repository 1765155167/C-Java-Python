// 面向对象设计原则-单例原则.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
//单例原则:类从始至终只有一个对象
//单例对象一般不需要释放，提供释放方法相当危险
//如果想释放可以使用嵌套类
//任务管理器 懒汉式单例模式：当需要该类时创建一个
class TaskManager
{
private:/*不允许类外定义/释放该类对象*/
	TaskManager()
	{
		this->a = 0;
		std::cout << "TaskManager()" << std::endl;
	}
	~TaskManager() {
	}
public:
	class Garbo {
		~Garbo() {
			if (task != NULL)
			{
				delete task;
			}
		}
	};
	static TaskManager* getInstance() {
		/*在多线程程序中不能保证之创建一次，所以在多线程中饿汉式单例更安全*/
		if (task == NULL)/*需要时创建一次并且只创建一次*/
		{
			task = new TaskManager;
		}
		return task;
	}
	void show() {
		a++;
		std::cout << "任务管理器正在工作" << a << std::endl;
	}
private:
	static TaskManager* task;
	static Garbo g;//静态函数在程序结束时会调用析构函数
	int a;
};
TaskManager* TaskManager::task = NULL;
//饿汉式：不管需不需要使用该类在main函数只想前就定义该类对象
//TaskManager* TaskManager::task = new TaskManager;
int main()
{
	/*TaskManager 类对象始终只有一个*/
	TaskManager* task1 = TaskManager::getInstance();
	task1->show();
	TaskManager* task2 = TaskManager::getInstance();
	task2->show();
	return 0;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
