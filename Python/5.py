import math 
def is_prime(number):#判断素数
    if number > 1:
        if number == 2:
            return True
        if number % 2 == 0:
            return False
        for current in range(3, int(math.sqrt(number) + 1), 2):
            if number % current == 0: 
                return False
        return True
    return False
num = int(input('请输入一个数：'))
if(is_prime(num)):
    print('{0} is prime(素数)'.format(num))
else:
    print('{0} not is prime(素数)'.format(num))
