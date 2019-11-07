# encoding: utf-8

from Data import Queue
from Data import Stack

def hotPhoto(nameList, num):
	semQueue = Queue()
	for name in nameList:
		semQueue.enQueue(name)

	while semQueue.size() > 1:
		for i in range(num):
			semQueue.enQueue(semQueue.deQueue())
		
		semQueue.deQueue()

	return semQueue.deQueue()

print(hotPhoto(["HQF", "HBT", "LSK", "LY", "WSS", "ZHF", "ZYH", " ZKD"], 7))