class Student:
    name = 10
    def __init__(self):
        self.name = "无名氏"
        self.age = 0

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def setName(self, name):
        self.name = name

    def toString(self):
        return self.name + str(self.age)

def funcation(var):
    "打印到屏幕"
    print(var)

funcation("你好世界")

stu1 = Student(name="胡秋峰", age=20)
print(stu1.toString())
stu2 = Student(name="Hello", age=12)
print(stu2.toString())
print(stu1.toString() + Student.name.__str__())

num = 5
for a in range(0,num):
    print(a,end=" ")
print()

a = []
for x in range(0, num):
    a.append(x)

print(a)