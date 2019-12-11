#include "Computer.h"
#include "AMDCard.h"
#include "AMDCPU.h"
#include "InterCard.h"
#include "InterCPU.h"
#include "NVIDACard.h"
#include "Samsung.h"
#include "KVR16N11.h"
int main()
{
	Computer* com1 = 
		new Computer(new AMDCard, new Samsung, new InterCPU);
	Computer* com2 =
		new Computer(new NVIDACard, new KVR16N11, new AMDCPU);
	com1->show();
	std::cout << "---------------------->" << std::endl;
	com2->show();
	delete com1;
	delete com2;
	return 0;
}
