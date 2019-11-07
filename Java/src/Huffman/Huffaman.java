package Huffman;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node<T> implements Comparable<Node<T>> {

    private T data;         //节点数据
    private int weight;     //权重
    private Node<T> left;   //左孩子
    private Node<T> right;  //右孩子
    public Node(T data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "data:" + this.data + ",weight:" + this.weight + ";   ";
    }

    public int getWeight() {
        return weight;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node<T> o) {    //重写这个对象的排序方法，这里使用权重进行排序
        // TODO Auto-generated method stub
        if (o.weight > this.weight) {
            return 1;
        } else if (o.weight < this.weight) {
            return -1;
        }
        return 0;
    }
}

class HuffmanTree<T> {
    public static <T> Node<T> createTree(List<Node<T>> nodes) {   //参数是多个节点组成的队列
        while (nodes.size() > 1) {       //只剩一个节点是，退出循环
            Collections.sort(nodes);     //使用sort方法对nodes进行排序,CompareTo方法实现的是降序排列
            Node<T> left = nodes.get(nodes.size() - 1);  //取两个最小的节点
            Node<T> right = nodes.get(nodes.size() - 2);
            Node<T> parent = new Node<T>(null, left.getWeight() + right.getWeight());  //生成新节点，新节点的权重 = 两个权重最小节点的和
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(left);         //把原来的节点移出队列
            nodes.remove(right);
            nodes.add(parent);          //新节点入队
        }
        return nodes.get(0);            //取出唯一的节点
    }

    public static void levelDisplay(Node root) {  //使用对垒实现层次遍历
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //层次遍历
        while (!queue.isEmpty()) {
            Node pNode = queue.poll();
            System.out.println(pNode.toString());
            if (pNode.getLeft() != null) {
                queue.add(pNode.getLeft());
            }
            if (pNode.getRight() != null) {
                queue.add(pNode.getRight());
            }
        }
    }
}

class Huffman {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Node<String>> nodes = new ArrayList<Node<String>>();
        nodes.add(new Node<String>("0-59", 45));
        nodes.add(new Node<String>("60-69", 42));
        nodes.add(new Node<String>("70-79", 60));
        nodes.add(new Node<String>("80-89", 100));
        nodes.add(new Node<String>("90-100", 75));
        Node<String> root = HuffmanTree.createTree(nodes);
        HuffmanTree.levelDisplay(root);
    }
}
