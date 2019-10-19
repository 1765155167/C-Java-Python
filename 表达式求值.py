# encoding: utf-8
class Stack:
    """模拟栈"""
    def __init__(self): 
        self.items = [] 
 
    def isEmpty(self): 
        return len(self.items)==0  
 
    def push(self, item): 
        self.items.append(item) 
 
    def pop(self): 
        return self.items.pop()  
 
    def peek(self): 
        if not self.isEmpty(): 
            return self.items[len(self.items)-1] 
 
    def size(self): 
        return len(self.items)

#转换成后缀表达式
def infixToPostfix(infixexpr):
    #记录操作符优先级
    prec = {}
    prec["*"] = 3
    prec["/"] = 3
    prec["+"] = 2
    prec["-"] = 2
    prec["("] = 1
    opStack = Stack()
    
    #存放后缀表达式
    postfixList = []
    #解析表达式到单词列表
    tokenList = infixexpr.split()
    #扫描A
    for token in tokenList:
        if token in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" or token in "0123456789":
            postfixList.append(token)
        elif token == "(":
            opStack.push(token)
        elif token == ")":
            topken = opStack.pop()
            while topken != "(":
                postfixList.append(topken)
                topken = opStack.pop()
        else:
            while (not opStack.isEmpty()) and (prec[opStack.peek()] >= prec[token]):
                postfixList.append(opStack.pop())
            opStack.push(token)

    while not opStack.isEmpty():
        postfixList.append(opStack.pop())

    return " ".join(postfixList)

def doMath(op, op1, op2):
    if op == "*":
        return op1 * op2
    elif op == "/":
        return op1 / op2
    elif op == "+":
        return op1 + op2
    elif op == "-":
        return op1 - op2
    else:
        print("op err")
        return -1

#后缀表达式求值
def postfixEval(postfixExpr):
    operandStack = Stack()
    tockenList = postfixExpr.split()
    #扫描计算
    for tocken in tockenList:
        if tocken in "0123456789":
            operandStack.push(int(tocken))
        else:
            operand2 = operandStack.pop()
            operand1 = operandStack.pop()
            result = doMath(tocken, operand1, operand2)
            operandStack.push(result)
    return operandStack.pop()


str = infixToPostfix("( A * B + C ) * C + D")
print(str)
print(postfixEval(str))
