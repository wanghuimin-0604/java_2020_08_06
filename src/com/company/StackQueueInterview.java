package com.company;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-08-06
 * Time:14:02
 * 一万年太久，只争朝夕，加油
 */

import java.util.Stack;

/**
 * 检查括号是否匹配
 */
public class StackQueueInterview {
    public static boolean isVaild(String str){
        //先判断字符串是否为空
        if(str==null){
            return true;
        }
        //是左括号，入栈
        //是右括号，取栈顶元素然后检查是否匹配
        //匹配的话就继续扫描，三种情况都不匹配的话就返回false就可以
        //当遍历完之后，看栈是否为空，空的话就返回true
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            //取到字符
            char c=str.charAt(i);
            if(c=='('||c=='{'||c=='['){
                //入栈
                stack.push(c);
                continue;
            }
            //如果不是左括号
            //先判断栈是否为空
            if(stack.isEmpty()){
                return false;
            }
            //是右括号
            //栈顶元素
            char top=stack.pop();
            if(top=='('&&c==')'){
                continue;
            }
            if(top=='['&&c==']'){
                continue;
            }
            if(top=='{'&&c=='}'){
                continue;
            }
            //走到这里说明栈顶元素和该元素不匹配
            return false;

        }
        //遍历完成
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str="({[]})";
        System.out.println(isVaild(str));
    }
}
