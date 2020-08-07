package com.test2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-08-06
 * Time:17:25
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
        //层序遍历
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }
            //用队列来模拟
            Queue<Node> queue=new LinkedList<>();
            //先把根节点入队列
            queue.offer(root);
            while(!queue.isEmpty()){
                //先打印根节点
                Node cur=queue.poll();
                System.out.print(cur.val+" ");
                if(cur.left!=null){
                    //左子树
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    //左子树
                    queue.offer(cur.right);
                }
            }
        }
        //先序遍历
        public static List<Character> preorderTraversal(Node root) {
            List<Character> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
            return result;
        }
        //先序遍历
        public static void FirstOrder(Node root) {
            if (root == null) {
                return;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                System.out.print(cur.val + " ");
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        //后序遍历
        public static void postordertraversal(Node root) {
            if(root==null){
                return;
            }
            //用栈来模拟
            Stack<Node> stack = new Stack<>();
            Node prev=null;
            Node cur=root;
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            while(true){
                //把左子树全部入栈
                while(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
                if(stack.isEmpty()) {
                    break;
                }
                //没有左子树了，那就取栈顶元素
                Node top=stack.peek();
                //看有没有右子树
                if(top.right==null||top.right==prev){
                    System.out.print(top.val+" ");
                    stack.pop();
                    prev=top;
                }else{
                    cur=top.right;
                }
            }
        }
        //后序遍历
        public List<Character> postOrder2(Node root){
            if(root == null) {
                return new ArrayList<>();
            }
            List<Character> list = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node tmp = stack.pop();
                list.add(tmp.val);
                if(tmp.left!=null){
                    stack.push(tmp.left);
                }
                if(tmp.right!=null){
                    stack.push(tmp.right);
                }
            }
            Collections.reverse(list);
            return list;
        }
        //后序遍历
        public static List<Character> postOrder3(Node root) {
            List<Character> ans = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            Node cur = root;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null && cur.left != null) {
                    stack.push(cur);
                    Node left = cur.left;
                    cur.left = null;
                    cur = left;
                } else if (cur != null && cur.right != null) {
                    stack.push(cur);
                    Node right = cur.right;
                    cur.right = null;
                    cur = right;
                } else if (cur.left == null && cur.right == null) {
                    ans.add(cur.val);
                    cur = stack.isEmpty() ? null : stack.pop();
                }
            }
            return ans;
        }
        //中序遍历
        public static List<Character> inorderTraversalhko9(Node root){
            List<Character> ret = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            Node cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                ret.add(cur.val);
                cur = cur.right;
            }
            return ret;
        }
        public static void main(String[] args) {
            Node node=build();
            List<Character> list=inorderTraversalhko9(node);
            for(char c:list){
                System.out.print(c+" ");
            }



        }
}