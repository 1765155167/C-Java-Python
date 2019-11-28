#求字符串中数字个数
str=input("请输入一串字符:")
sum1 = 0
for i in str:
    if i >= '0' and i <= '9':
        sum1 = sum1+1
print(sum1)
