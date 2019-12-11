// 面向对象设计模式-命令模式.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <queue>
#include <Windows.h>

//创建客户端请求命令集合
class ClientHandleCommendSet {
public:
	//请求一张图片
	void requestPhoto(int val)
	{
		std::cout << "请求图片:" << val << std::endl;
	}
	//请求视频
	void requestVideo(int param)
	{
		std::cout << "请求视频:" << param << std::endl;
	}
};

//创建处理请求的接口
class AbstractProcess {
public:
	virtual void handle() = 0;
};

class PhotoCommend :public AbstractProcess{
public:
	PhotoCommend(ClientHandleCommendSet* setCommend, int val) {
		this->setCommend = setCommend;
		this->val = val;
	}
	virtual void handle() {
		this->setCommend->requestPhoto(this->val);
	}
private:
	ClientHandleCommendSet* setCommend;
	int val;
};

class VideoCommend :public AbstractProcess {
public:
	VideoCommend(ClientHandleCommendSet* setCommend, int val) {
		this->setCommend = setCommend;
		this->val = val;
	}
	virtual void handle() {
		this->setCommend->requestVideo(this->val);
	}
private:
	ClientHandleCommendSet* setCommend;
	int val;
};

//服务器处理请求类
class Server {
public:
	Server() {

	}
	void addRequest(AbstractProcess* p) {
		this->proQue.push(p);
	}
	void startServar()
	{
		while (!this->proQue.empty())
		{
			Sleep(2000);
			AbstractProcess* p = this->proQue.front();
			this->proQue.pop();
			p->handle();
		}
	}
	~Server() {

	}
private:
	std::queue<AbstractProcess*> proQue;
};

void test01()
{
	ClientHandleCommendSet* clentSet = new ClientHandleCommendSet;
	//请求图片10004命令
	AbstractProcess* photh = new PhotoCommend(clentSet,10004);
	AbstractProcess* video = new VideoCommend(clentSet, 100568);

	Server* server = new Server;
	server->addRequest(photh);
	server->addRequest(video);
	server->startServar();
	
	delete server;
	delete video;
	delete photh;
	delete clentSet;
}

int main()
{
	test01();
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
