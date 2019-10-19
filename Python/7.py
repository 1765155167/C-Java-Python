answer = False
for i in range(3,0,-1):
    print("你还有%d次机会" % i)
    user = input("请输入账号：")
    passwd = input("请输入密码：")
    if user != 'admin':
        print("账户错误")
        continue
    if passwd != '123456':
        print("密码错误")
        continue
    if user == 'admin' and passwd == '123456':
        print("登陆成功")
        answer = True
        break
if answer == False:
    print("机会以用完")

