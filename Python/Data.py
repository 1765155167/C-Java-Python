# encoding: utf-8

class Queue:
    """模拟队列"""

    def __init__(self):
        self.items = []

    def is_Empty(self):
        return len(self.items) == 0

    def enQueue(self, item):
        self.items.insert(0, item)

    def deQueue(self):
        return self.items.pop()

    def size(self):
        return len(self.items)

class Stack:
    """模拟队列"""

    def __init__(self):
        self.items = []

    def is_Empty(self):
        return len(self.items) == 0

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

	def peek(self): 
		if not self.isEmpty(): 
			return self.items[len(self.items)-1] 

    def size(self):
        return len(self.items)


class Deque:
	"""模拟双端队列"""
	def __init__(self):
		self.items = []

	def addFromt(self, item):
		self.items.append(item)

	def addRear(self, item):
		self.items.insert(0, item)

	def removeFromt(self):
		return self.items.pop()

	def removeRear(self):
		return self.items.pop(0)

	def is_Empty(self):
		return len(self.items) == 0

	def size(self):
		return len(self.items)

