package chapter1;

import java.util.Stack;

//MaxSubMatrix 获取最大子矩阵
public class MaxSubMatrix {
    public static void  main(String []args){
        int[][] map ={{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        MaxSubMatrix maxSubMatrix=new MaxSubMatrix();
        int ret=maxSubMatrix.maxRecSize(map);
        System.out.print(ret);
    }
    public int maxRecSize(int[][] map){
        if(map==null || map.length==0 || map[0].length==0){
            return 0;
        }
        int maxArea=0;
        int[] height= new int[map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                height[j]=map[i][j]==0?0:height[j]+1;
            }
            maxArea=Math.max(maxRecFromBottom(height),maxArea);
        }
        return maxArea;
    }

    //维持一个递增队列
    public int maxRecFromBottom(int[] height){
        if(height==null || height.length==0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer>stack= new Stack<>();
        for(int i=0;i<height.length;i++){
            while((!stack.isEmpty()) && height[stack.peek()]>=height[i]){
                int j=stack.pop();
                int k= stack.isEmpty()?-1:stack.peek();
                int curArea =(i-k-1)*height[j];
                maxArea=Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
