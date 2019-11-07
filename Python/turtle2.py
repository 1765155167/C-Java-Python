import turtle

t = turtle.Turtle()

t.pencolor('red')
t.pensize(3)

def drawSpiral(t, lineLen):
    if lineLen > 0:
        t.forward(lineLen)
        t.right(90)
        drawSpiral(t, lineLen - 5)

drawSpiral(t, 200)
turtle.done()
