package com.dzx.code.tool.leetcode;
import java.util.*;
public class FRT1 {
    public static void main(String[] args) {
        int path = new FRT1().findPath("abcescfsadee",4,"bccfd");
        System.out.println(path);
    }

        int sum;
        int colomn = 0;
        boolean flag;
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * 返回路径点之和
         * @param matrix string字符串 矩阵值
         * @param cols int整型 矩阵列数量
         * @param key string字符串 需要检索的关键字
         * @return int整型
         */
        public int findPath (String matrix, int cols, String key) {
            colomn = cols;
            // write code here
            int len = matrix.length();
            int rows = len / cols;
            char[][] mat = new char[rows][cols];
            for(int i = 0;i<len;i++){
                int row = i / cols;
                int col = i % cols;
                if(row % 2 == 0){
                    mat[row][col] = matrix.charAt(i);
                }else{
                    mat[row][cols-1-col] = matrix.charAt(i);
                }

            }
            for(int i = 0;i<rows;i++){
                for(int j = 0;j<cols;j++){
                    if(mat[i][j] == key.charAt(0)){
                        flag = false;
                        dfs(mat,0,i,j,key,0,new boolean[rows][cols]);
                    }
                }
            }
            return sum == 0? -1:sum;



        }
        public void dfs(char[][] mat,int index, int row, int col, String key,int val,boolean[][] visited){
            if(flag){
                return;
            }
            if(index == key.length()){
                sum += val;
                flag = true;
                return;
            }
            if(row < 0 || row >= mat.length || col <0 || col >= mat[0].length){
                return;
            }
            if(visited[row][col]){
                return;
            }
            if(mat[row][col] != key.charAt(index)){
                return;
            }
            visited[row][col] = true;
            int temp = (row % 2 == 0)?col+row * colomn : colomn-1-col+row * colomn;
            dfs(mat,index+1,row-1,col,key,val+temp,visited);
            dfs(mat,index+1,row+1,col,key,val+temp,visited);
            dfs(mat,index+1,row,col-1,key,val+temp,visited);
            dfs(mat,index+1,row,col+1,key,val+temp,visited);
        }

}
