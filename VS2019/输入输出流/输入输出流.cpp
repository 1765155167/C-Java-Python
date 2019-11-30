// 输入输出流.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <iomanip>

void test01()
{
	using namespace std;
	cout << "请输入数字或者字符串" << endl;
	char ch;
	ch = cin.peek();//偷窥
	if (ch >= '0' && ch <= '9')
	{
		int num;
		cin >> num;
		cout << "你输入的数字为：" << num << endl;
	}
	else
	{
		string buf;
		cin >> buf;
		cout << "你输入的字符串为：" << buf << endl;
	}
}

void test02()
{
	using namespace std;
	char name[10] = "Mr.Hu\n";
	cout.put('0').put('1').put('2').put('\n');
	cout.write((char *)name, strlen(name));

	cout << R"(Hello I'am Mr.hu 
I want to meet you)"
<< endl;
}

void test03()
{
	using namespace std;
	cout.unsetf(ios::dec);
	cout.setf(ios::oct);
	cout.setf(ios::showbase);
	cout << "10=" << 10 << endl;
	cout.unsetf(ios::oct);
	cout.setf(ios::hex);
	cout << "255=" << 255 << endl;
}

void test04()
{
	using namespace std;
	struct Time {
		int year;
		int mounth;
		int day;
		int hour;
		int min;
		int sencond;
	};
	struct Time t = { 2019,1,24,16,28,2 };
	cout << setw(4)
		<< setiosflags(ios::right)
		<< setfill('0')
		<< t.year << "-" << setw(2)
		<< t.mounth << "-" << setw(2)
		<< t.day << " " << setw(2)
		<< t.hour << "-" << setw(2)
		<< t.min << "-" << setw(2)
		<< t.sencond << endl;
}

void test05()
{
#if 0
	char ch;
	//std::cin.get() 等待缓冲区有数据，
	//键盘输入数据并且按回车才会将数据放到缓冲区
	//EOF ：Ctrl+C
	while ((ch = std::cin.get()) != EOF) {
		std::cout << ch << std::endl;
	}
#endif

#if 0
	//char ch2;
	//std::cin.get(ch);
	char buf[256] = { 0 };
	std::cin.get(buf, 256);
	//std::cin.getline(buf, 256);//读取一行不读换行符
	std::cout << buf;
#endif // 0
	
#if 0
	//std::cin.ignore();//忽略当前字符
	std::cin.ignore(10, '\n');//最多忽略10个字符知道遇见'\n'
	char ch = std::cin.peek();//偷窥一个字符不从缓冲区取走
#endif // 0

#if 0

	std::cin.putback('a');//放一个数据到缓冲区
	char ch1 = std::cin.peek();//偷窥缓冲区
	char ch2 = std::cin.get();//读取一个字符
	std::cout << ch1 << ":" << ch2 << std::endl;
#endif // 1
	
}
/*
	std::cin;//标准输入流 等待缓冲区有数据
	std::cout;//标准输出流 输出到缓冲区 不会立刻输出到显示器除非遇见
	std::endl;//刷新缓冲区
	std::cerr;//标准错误流 没有缓冲区
	std::clog;//标准日志流 有缓冲区
*/
int main()
{
	test04();
    std::cout << "Hello World!\n";
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
