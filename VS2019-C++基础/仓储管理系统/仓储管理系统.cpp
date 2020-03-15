// 仓储管理系统.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>

class Goods {
public:
	Goods() :weight(0), value(0), next(NULL) {
		std::cout << "Goods()..." << std::endl;
	}
	Goods(int w, int value) :weight(w), value(value), next(NULL)
	{
		std::cout << "Goods(int w, int value)..." << std::endl;
		this->totle_weight += w;
	}
	Goods(Goods& another)
	{
		std::cout << "Goods(Goods& another)..." << std::endl;
		this->weight = another.weight;
		this->value = another.value;
		this->next = another.next;
		this->totle_weight += another.weight;
	}
	~Goods()
	{
		std::cout << "~Goods" << this->totle_weight << std::endl;
		this->totle_weight -= this->weight;
	}
	void show()
	{
		std::cout << "weight:" << weight << " value:" << value << std::endl;
	}
	static int getTotleWeight() {
		return totle_weight;
	}
	friend static void Calculation(Goods* head);
	Goods* next;
private:
	int weight;
	int value;
	static int totle_weight;
};
int Goods::totle_weight = 0;

void Traversing(Goods *head)
{
	Goods* temp = head;
	while (temp != NULL)
	{
		temp->show();
		temp = temp->next;
	}
}

void Purchase(Goods* &head, int w, int v)
{
	Goods* temp = new Goods(w, v);
	if (head == NULL)
	{
		head = temp;
	}
	else
	{
		temp->next = head;//头插法
		head = temp;
	}
	return;
}

void Shipment(Goods* &head)
{
	if (head == NULL)
	{
		std::cout << "仓库中没有货物" << std::endl;
		return;
	}
	Goods* temp = head;
	head = head->next;
	delete temp;
}

void save(Goods* head)
{
	const char* filePath = ".\\Goods";
	std::ofstream osm(filePath,
		std::ios::out | std::ios::binary | std::ios::trunc);
	if (!osm) {
		std::cout << "文件" << filePath << "打开失败" << std::endl;
		return;
	}
	while (head!=NULL)
	{
		osm.write((char*)head, sizeof(Goods));
		head = head->next;
	}
}

Goods* load()
{
	Goods* head = NULL;
	const char* filePath = ".\\Goods";
	std::ifstream ism(filePath, std::ios::in | std::ios::binary);
	if (!ism) {
		std::cout << "文件" << filePath << "打开失败" << std::endl;
		return NULL;
	}
	while (true)
	{
		Goods *q = new Goods;
		if (!ism.read((char*)q, sizeof(Goods)))
		{
			delete q;
			q = NULL;
			break;
		}
		q->next = NULL;
		if (head == NULL)
		{
			head = q;
			continue;
		}
		q->next = head;
		head = q;
	}
	Calculation(head);
	return head;
}

void exit_System(Goods* head)
{
	std::cout << "系统已经退出" << std::endl;
	save(head);
	return;
}

int main()
{
	int choice = 0;
	Goods *head = load();
	do
	{
		Traversing(head);
		std::cout << "当前货物总重量:" << Goods::getTotleWeight() << std::endl;
		std::cout << "1:进货" << std::endl;
		std::cout << "2:出货" << std::endl;
		std::cout << "3:遍历" << std::endl;
		std::cout << "0.退出" << std::endl;
		std::cout << "请输入选项:";
		std::cin >> choice;
		switch (choice)
		{
		case 1:
			int w, v;
			std::cout << "请输入货物重量与价格" << std::endl;
			std::cin >> w >> v;
			Purchase(head, w, v);
			break;
		case 2: 
			Shipment(head);
			break;
		case 3:
			Traversing(head);
			break;
		case 0:
			exit_System(head);
			return 0;
		default:
			break;
		}
		system("cls");
	} while (true);
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

void Calculation(Goods* head)
{
	Goods* temp = head;
	temp->totle_weight = 0;
	while (temp != NULL)
	{
		temp->totle_weight += temp->weight;
		temp = temp->next;
	}
}
