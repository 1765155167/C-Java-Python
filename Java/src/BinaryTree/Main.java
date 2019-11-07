package BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    /*
    * 前序遍历递归
    * */
    public static void preTraversalRec(BinaryTree tree)
    {
        if (tree == null)
        {
            System.out.println("null");
            return;
        }
        System.out.println("tree:"+tree.val);
        preTraversalRec(tree.lTree);
        preTraversalRec(tree.rTree);
    }
    /*
    * 前序遍历非递归
    * */
    public static void preTraversal(BinaryTree tree)
    {
        if (tree == null)
        {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty())
        {
            BinaryTree temp = stack.pop();
            System.out.println(temp.val);
            if (temp.rTree != null)
            {
                stack.push(temp.rTree);
            }
            if (temp.lTree != null)
            {
                stack.push(temp.lTree);
            }
        }
    }
    /*
    * @创建二叉树 前序创建
    * */
    public static void creatBinaryTree(BinaryTree root)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a == 0)
        {
            root = new BinaryTree(0);
        } else {
            root = new BinaryTree(a);
            System.out.println("创建"+a);
            creatBinaryTree(root.lTree);
            creatBinaryTree(root.rTree);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        creatBinaryTree(tree);
        preTraversalRec(tree);
    }
}
