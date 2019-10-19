import math
def my_abs(x):
    if not isinstance(x,(int,float)):
        raise TypeError('bad operand type')
    if x >= 0:
        return x
    else:
        return -x
def quadratic(a, b, c):#二次方程的解
    if not isinstance(a,(int,float)):
        raise TypeError('a : bad operand type')
    if not isinstance(b,(int,float)):
        raise TypeError('b: bad operand type')
    if not isinstance(c,(int,float)):
        raise TypeError('c : bad operand type')
    drt = (b*b - 4*a*c)
    if drt < 0:
        return
    elif drt == 0:
        return (-b/(2*a))
    else:
        return ((-b+math.sqrt(drt))/(2*a),(-b-math.sqrt(drt))/(2*a))

def fact(n):
    if not isinstance(n,(int)):
        raise TypeError('bad operand type')
    if n < 1:
        raise TypeError('number min 1')
    if n==1:
        return 1
    return n * fact(n - 1)
