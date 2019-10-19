# coding: utf-8
from Data import Queue
import random

"""
模拟标准打印机:先来先打印
Task：打印任务（打印提交时间，打印纸张）
Printer：打印机类
使用：simulation(3600, 50)  # 模拟打印时间3600s（一小时） Speed = 50张/分
"""

class Task:
    def __init__(self, time):
        self.timeStamp = time  # 打印任务提交时间
        self.pages = random.randrange(1, 21)  # 打印纸张

    def getStamp(self):
        return self.timeStamp

    def getPages(self):
        return self.pages

    def waitTime(self, currentTime):
        return currentTime - self.timeStamp


class Printer:
    def __init__(self, ppm):
        self.printSpeed = ppm  # 打印速度
        self.currentTask = None  # 打印任务
        self.timeRemaining = 0  # 任务倒计时

    def tick(self):    # 打印 1 s
        if self.currentTask is not None:
            self.timeRemaining = self.timeRemaining - 1
            if self.timeRemaining <= 0:
                self.currentTask = None

    def busy(self):  # 判断打印机是否忙
        if self.currentTask is not None:  # 打印任务不为空
            return True
        else:
            return False

    def startNext(self, newTask):  # 开始打印新的任务 newTask
        self.currentTask = newTask
        self.timeRemaining = newTask.getPages() * 60 / self.printSpeed

# 提交新的打印任务为 1/180
def newPrintTask():
    num = random.randrange(1, 181)
    if num == 180:
        return True
    else:
        return False

# numSeconds：模拟打印时间
# pagesPerMinute：打印速度：张/分
def simulation(numSeconds, pagesPerMinute):
    labPrinter = Printer(pagesPerMinute)
    printQueue = Queue()
    waitingTimes = []

    for currentSecond in range(numSeconds):

        if newPrintTask():
            task = Task(currentSecond)
            printQueue.enQueue(task)

        if not labPrinter.busy() and not printQueue.is_Empty():
            nextTask = printQueue.deQueue()
            waitingTimes.append(nextTask.waitTime(currentSecond))
            labPrinter.startNext(nextTask)

        labPrinter.tick()

    averageWait = sum(waitingTimes) / len(waitingTimes)
    print("Max wait %4d Average wait %6.2f secs %3d tasks remaining." % (max(waitingTimes), averageWait, printQueue.size()))


for i in range(10):
    simulation(3600, 50)  # 3600s Speed = 5: 1 min print 50 page
