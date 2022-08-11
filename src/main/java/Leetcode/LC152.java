package Leetcode;

import java.util.LinkedList;

public class LC152 {

    public static void main(String[] args) {
        int[] nums = {2,0,3,-2};
        System.out.println(new Solution1().maxProduct(nums));
        System.out.println(new Solution2().maxProduct(nums));
    }

    /**
     * 采用零区间分割的方法完成 控制下边界条件即可
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 66.34%
     * 的用户
     * 内存消耗：
     * 41.8 MB
     * , 在所有 Java 提交中击败了
     * 29.91%
     * 的用户
     */
    static class Solution1 {
        public int maxProduct(int[] nums) {
            //核心在于0的位置以及负数个数上
            //以0为边界开始
            int len = nums.length;
            LinkedList<Integer> zeros = new LinkedList<>();
            zeros.add(len);
            int count = 0;
            for(int i = nums.length-1;i>=0;i--){

                if(nums[i] == 0){
                    zeros.addFirst(i);
                }

            }
            zeros.addFirst(-1);
            int max = Integer.MIN_VALUE;

            for(int i = 0;i<zeros.size()-1;i++){
                int multi = 1;
                int leftnega = 1;
                int rightnega = 1;
                boolean flag1 = true;
                boolean flag2 = true;
                // 1  -1
                if(zeros.get(i+1) - zeros.get(i) -1 == 1 ){
                    max = Math.max(max,nums[zeros.get(i)+1]);
                }else{
                    int size = zeros.get(i+1) - zeros.get(i) -1;
                    for(int j = zeros.get(i)+1;j<zeros.get(i+1);j++){
                        if(flag1){
                            leftnega *= nums[j];
                            if(nums[j] < 0){
                                flag1 = false;
                            }
                        }
                        if(flag2){
                            rightnega *= nums[zeros.get(i+1) - j + zeros.get(i)];
                            if(nums[zeros.get(i+1) - j + zeros.get(i)] < 0){
                                flag2 = false;
                            }
                        }
                        multi *= nums[j];
                    }
                    if(size > 0){
                        if(multi > 0){
                            max = Math.max(max,multi);
                        }else{
                            int temp = Math.max(multi/leftnega,multi/rightnega);
                            max = Math.max(max,temp);
                        }
                    }
                }

            }
            if(max < 0 && zeros.size() > 2) max = 0;
            if(zeros.size() -2 == len) max = 0;
            return max;
        }
    }

    /**
     * DP
     * 遍历数组时计算当前最大值，不断更新
     * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     * 当负数出现时则imax与imin进行交换再进行下一步计算
     * 时间复杂度：O(n)
     */
    static class Solution2{
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int imax = 1;
            int imin = 1;
            int ans = nums[0];
            for(int i = 0;i<len;i++){
                imax = Math.max(imax*nums[i],nums[i]);
                imin = Math.min(imin*nums[i],nums[i]);
                if(nums[i] < 0){
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                ans = Math.max(ans,imax);
            }
            return ans;
        }
    }
}
