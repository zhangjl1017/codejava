/**
 * Created by zjladmin on 2016/9/22.
 */
import java.util.Scanner;
public class MainTree {
    public static void main(String[] args) {
        Node t = new Node();
        Node.createTree(t);
        System.out.println("t");
        System.out.print("先序遍历:");
        Node.preOrder(t);
        System.out.println();
        System.out.print("后序遍历:");
        Node.lastOrder(t);
    }
}


class Node {
    public String value; // 字母节点
    public Node left, right;// 左右子节点

    static String getChar() {
        Scanner sc = new Scanner(System.in);
        return sc.next();

    }

    static void createTree(Node t) {
        String c = getChar();
        if ("0".equals(c)) {
            t.value = "0";
        } else {
            t.value = c;
            t.left = new Node();
            createTree(t.left);
            t.right = new Node();
            createTree(t.right);
        }
    }

    static void preOrder(Node t) {
        if(null != t) {
            System.out.print(t.value + " ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }


    static void lastOrder(Node t) {
        if(null != t) {
            lastOrder(t.left);
            lastOrder(t.right);
            System.out.print(t.value + " ");
        }
    }
}