/**
 * Created by zjladmin on 2016/9/18.
 */
import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/18.
 */
public class Main { private int[][] maze = null;
    private int[] xx = { 1, 0, -1, 0 };
    private int[] yy = { 0, 1, 0, -1 };
    private Queue queue = null; public Main(int[][] maze) {
        this.maze = maze;
        queue = new Queue(maze.length * maze.length);
    }
    public void go(int bu) {
        Point outPt = new Point(0, maze[0].length - 1);
        Point curPt = new Point(0, 0);
        Node curNode = new Node(curPt, null);
        maze[curPt.x][curPt.y] = 2;
        queue.entryQ(curNode);
        while (!queue.isEmpty()) {
            curNode = queue.outQ();
            for (int i = 0; i < xx.length; ++i) {
                Point nextPt = new Point();
                nextPt.x = (curNode.point).x + xx[i];
                nextPt.y = (curNode.point).y + yy[i];
                if (check(nextPt)) {
                    Node nextNode = new Node(nextPt, curNode);
                    queue.entryQ(nextNode);
                    maze[nextPt.x][nextPt.y] = 2;
                    if (nextPt.equals(outPt)) {
                        java.util.Stack<Node> stack = new java.util.Stack<Node>();
                        stack.push(nextNode);
                        while ((curNode = nextNode.previous) != null) {
                            nextNode = curNode;
                            stack.push(curNode);
                        }
                        if(stack.size()>bu){
                            System.out.println("Can not escape!");
                            return;
                        }
                        curNode = stack.pop();
                        System.out.print(curNode.point);
                        while (!stack.isEmpty()) {
                            System.out.print(",");
                            curNode = stack.pop();
                            System.out.print(curNode.point);
                        }
                        System.out.println();
                        return;
                    }
                }
            }
        }
        System.out.println("Can not escape!");
    }
    private boolean check(Point p) {
        if (p.x < 0 || p.x >= maze.length || p.y < 0 || p.y >= maze[0].length) {
            return false;
        }
        if (maze[p.x][p.y] != 1) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int p=sc.nextInt();
            int[][] maze = new int[n][];
            for(int i=0;i<n;i++)
                maze[i]=new int[m];
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++) {
                    maze[i][j] = sc.nextInt();
                    // maze[i][j]=maze[i][j]==1?0:1;
                }
            new Main(maze).go(p);
        }
    }
    private class Queue {  Node[] array = null;
        int size = 0;
        int len = 0;
        int head = 0;
        int tail = 0;
        public Queue(int n) {
            array = new Node[n + 1];
            size = n + 1;
        }
        public boolean entryQ(Node node) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % size;
            array[tail] = node;
            len++;
            return true;
        }
        public Node outQ() {
            if (isEmpty()) {
                return null;
            }
            head = (head + 1) % size;
            len--;
            return array[head];
        }
        public boolean isEmpty() {
            return (len == 0 || head == tail) ? true : false;
        }
        public boolean isFull() {
            return ((tail + 1) % size == head) ? true : false;
        }
    }
    private class Node {
        Point point = null;
        Node previous = null;  public Node() {
            this(null,null);
        }
        public Node(Point point, Node node) {
            this.point = point;
            this.previous = node;
        }
    }
    private class Point {  int x = 0;
        int y = 0;  public Point() {
            this(0, 0);
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean equals(Point p) {
            return (x == p.x) && (y == p.y);
        }
        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
}
