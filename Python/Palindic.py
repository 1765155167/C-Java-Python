# coding: utf-8

from Data import Deque

def palindic(aString):
	deque = Deque()

	for x in aString:
		deque.addFromt(x)
	
	result = True
	while deque.size() > 1 and result:
		if deque.removeFromt() != deque.removeRear():
			result = False
	
	return result


print(palindic("LLlALLL"))