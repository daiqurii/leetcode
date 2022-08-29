package com.dzx.code.tool.newCoder;

public class JZ54 {

    public static void main(String[] args) {

    }
    int res = -1;
    boolean flag = false;
    int k = 0;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param proot TreeNode类
     * @param k int整型
     * @return int整型
     */
    public int KthNode (TreeNode proot, int k) {
        this.k = k;
        // write code here
        tranverse(proot);
        return res;

    }

    public void tranverse(TreeNode root){
        if(root == null) return;

        tranverse(root.left);
        //k需要作为一个全局的变量
        k--;
        if(flag) return;
        if(k == 0){
            res = root.val;
            flag = true;
            return;
        }
        tranverse(root.right);

    }

    public class TreeNode {
       int val = 0;
       TreeNode left = null;
       TreeNode right = null;
       public TreeNode(int val) {
         this.val = val;
       }
    }
}
