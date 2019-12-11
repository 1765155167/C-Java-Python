#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
//迪米特法则 最少知识原则
//用户完成的步骤越少越好


//抽象类
class AbstractBuild {
public:
	virtual void sale() = 0;
	std::string getQulity() {
		return this->qulity;
	}
	virtual ~AbstractBuild() {

	}
protected:
	std::string qulity;//楼盘质量
};

//楼盘A
class BuildA : public AbstractBuild {
public:
	BuildA() {
		this->qulity = "高品质";
	}
	void sale() {
		std::cout << "楼盘A" << this->qulity << "被售卖" << std::endl;
	}
	~BuildA() {

	}
};

//楼盘B
class BuildB : public AbstractBuild {
public:
	BuildB() {
		this->qulity = "低品质";
	}
	void sale() {
		std::cout << "楼盘B" << this->qulity << "被售卖" << std::endl;
	}
	~BuildB() {
		
	}
};

//客户端：用户想买一个低品质楼盘
//用于需要与每一个楼盘打交道
void client01()
{
	BuildA* bA = new BuildA;
	if (bA->getQulity() == "低品质")
	{
		bA->sale();
	}
	delete bA;

	BuildB* bB = new BuildB;
	if (bB->getQulity() == "低品质")
	{
		bB->sale();
	}
	delete bB;
}

//中介类
class Mediator
{
public:
	Mediator() {
		this->vBuild.push_back(new BuildA);
		this->vBuild.push_back(new BuildB);
	}
	AbstractBuild* findBuild(std::string qulity)
	{
		for (auto it = this->vBuild.begin();
			it != this->vBuild.end(); it++) {
			if ((*it)->getQulity() == qulity)
			{
				return *it;
			}
		}
		return NULL;
	}
	~Mediator() {
		for (auto it = this->vBuild.begin();
			it != this->vBuild.end(); it++) {
			delete* it;
		}
	}

private:
	std::vector<AbstractBuild*> vBuild;
};

//通过中介类进行买房
void client02()
{
	Mediator* media = new Mediator;
	AbstractBuild* build = media->findBuild("高品质");//客户没有new的不需要释放
	if (build != NULL)
	{
		build->sale();
	}
	else
	{
		std::cout << "没有找到你想要的楼盘" << std::endl;
	}
	delete media;
}

int main()
{
	client02();
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
