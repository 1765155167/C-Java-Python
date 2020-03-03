package 集合.stack;

import java.util.Arrays;

public class MyStack {
    private int[] data;
    private int capacity;//容量
    private int count;//元素个数

    public MyStack() {
        this.data = new int[8];
        this.capacity = 8;
        this.count = 0;
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.count = 0;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void push(int data) {
        if (this.capacity == this.count) {
            ensureCapacity();
        }
        this.data[count++] = data;
    }

    private void ensureCapacity() {
        this.capacity = this.capacity * 2;
        this.data = Arrays.copyOf(this.data, this.capacity);
    }

    public int pop() {
        if (this.count == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return this.data[--count];
    }

    public int peek() {
        if (this.count == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return this.data[count];
    }
}
