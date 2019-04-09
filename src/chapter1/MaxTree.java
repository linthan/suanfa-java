package chapter1;

import java.util.HashMap;
import java.util.Stack;

public class MaxTree {
  public class Node {
    public int value;
    public Node left;
    public Node right;
    public Node(int data){
        this.value=data;
    }
  }

  public static void main(String[] args) {
      MaxTree tree=new MaxTree();
      int []arr ={3,4,5,1,2};
      Node head =tree.getMaxTree(arr);
      tree.preOrder(head);

  }
  public void preOrder(Node head){
      if(head==null){
          return;
      }
      System.out.print(head.value);
      preOrder(head.left);
      preOrder(head.right);
  }
  public  Node  getMaxTree(int[] arr){
      Node[] nArr = new Node[arr.length];
      for(int i=0;i!=arr.length;i++){
          nArr[i]=new Node(arr[i]);
      }
      Stack<Node> stack=new Stack<>();
      HashMap<Node,Node>lBigMap =new HashMap<>();
      HashMap<Node,Node>rBigMap =new HashMap<>();
      //设置左边的最大值
      for (int i=0;i<nArr.length;i++){
          Node curNode=nArr[i];
          while((!stack.isEmpty())&& stack.peek().value<curNode.value){
                popStackSetMap(stack,lBigMap);
          }
          stack.push(curNode);
      }
      while(!stack.isEmpty()){
          popStackSetMap(stack,lBigMap);
      }
      for(int i=nArr.length-1;i>-1;i--){
        Node curNode=nArr[i];
        while((!stack.isEmpty()) && stack.peek().value<curNode.value){
            popStackSetMap(stack,rBigMap);
        }
        stack.push(curNode);
      }
      while(!stack.isEmpty()){
          popStackSetMap(stack,rBigMap);
      }
      Node head=null;
      for(int i=0;i<nArr.length;i++){
          Node curNode =nArr[i];
          Node left =lBigMap.get(curNode);
          Node right =rBigMap.get(curNode);
          if(left==null && right==null){
              head=curNode;
          }else if(left==null){
              //已经证明了在一遍最多只能有一个子节点
              if(right.left==null){
                  right.left=curNode;
              }
          }else if(right==null){
              if(left.right==null){
                  left.right=curNode;
              }
          } else {
                Node parent =left.value<right.value?left:right;
                if(parent.left==null){
                    parent.left=curNode;
                }else{
                    parent.right=curNode;
                }
          }
      }
      return head;
  }

  public void popStackSetMap(Stack<Node> stack, HashMap<Node,Node>map){
      Node popNode =stack.pop();
      if (stack.isEmpty()){

          map.put(popNode,null);
      }else{
          map.put(popNode,stack.peek());
      }
  }
}
