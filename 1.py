# coding: utf-8

def fun(n):
	sum = 0
	for i in range(1, n + 1):
		for j in range(1, i + 1):
			for k in range(1, j + 1):
				print("i:",i,"j:",j,"k:",k)
				sum += 1
	
	return sum


print(fun(5))
