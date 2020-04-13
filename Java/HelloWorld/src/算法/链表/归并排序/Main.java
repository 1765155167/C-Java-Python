package 算法.链表.归并排序;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.mergeSort().toPrint();
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node mergeSort() {//归并排序
        Node head = this;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node midNode = getMiddle(head);//将head链表分割成head与midNode
        return merge(head.mergeSort(), midNode.mergeSort());//递归合并
    }

    //合并两个有序数组
    private Node merge(Node p1, Node p2) {
        Node dummy = new Node(-1);
        Node p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.value > p2.value) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    //求链表中间节点并将其分开 快慢节点法
    private Node getMiddle(Node head) {
        Node quite = head;
        Node slow = head;
        while (quite.next != null && quite.next.next != null) {
            quite = quite.next.next;
            slow = slow.next;
        }
        Node node = slow.next;
        slow.next = null;
        return node;
    }

    //提供打印测试方法
    public void toPrint() {
        Node node = this;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}