package com.test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-08-06
 * Time:15:54
 * 一万年太久，只争朝夕，加油
 */
class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }
    @Override
    public String toString() {
        return  "Node{" +
                "val=" + val +
                '}';
    }
}

public class Main {
    // 辅助我们构造测试数据的.
    static Node build() {
        // 通过 build 方法构建一棵树, 返回树的根节点.
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }
    //检查两棵树是否相同
    //值相同、树的结构相同
    public static boolean isSameTree(Node p,Node q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    //判断某棵树是不是另一棵树的子树
    public static boolean isSubTree(Node s,Node t){
        if(s==null){
            return false;
        }
        return isSameTree(s,t)||isSubTree(s.left,t)||isSubTree(s.right,t);
    }

    public static void main(String[] args) {
        Node p=build();
        Node q=build();
        System.out.println(isSubTree(p, q));
    }
}

