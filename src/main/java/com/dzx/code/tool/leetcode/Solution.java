package com.dzx.code.tool.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{2,1},{2,4}};

        int i = solution.minNumberOfSemesters(4, nums, 2);
        System.out.println("answer:"+i);
    }
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        Lesson[] lessons = new Lesson[n];
        for(int i = 0;i<n;i++){
            Lesson lesson = new Lesson();
            lessons[i] = lesson;
        }
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        for(int[] relation:relations){
            lessons[relation[0]-1].out.add(relation[1]-1);
            lessons[relation[1]-1].in.add(relation[0]-1);
            indegree[relation[1]-1]++;
            outdegree[relation[0]-1]++;
        }
        List<Integer> starts = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(outdegree[i] == 0){
                //出度为0 表示最后一个节点
                lessons[i].floor = 0;
                starts.add(i);
            }
        }
        //编号
        for(int start:starts){
            Lesson lesson = lessons[start];
            dfs(lesson,lessons);
        }
        //按照入度添加到大根堆中 再每次消费k个
        PriorityQueue<Lesson> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.floor - o1.floor);
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0){
                priorityQueue.add(lessons[i]);
            }
        }
        int ans = 0;
        while(n>0){
            List<Lesson> list = new ArrayList<>();
            for(int i = 0;(i<k) && !priorityQueue.isEmpty();i++){
                Lesson lesson = priorityQueue.poll();
                n--;
                for(int index:lesson.out){
                    if(index != -1){
                        indegree[index]--;
                        if(indegree[index] == 0){
                            list.add(lessons[index]);
                        }
                    }
                }

            }
            priorityQueue.addAll(list);
            ans++;
        }
        return ans;

    }
    public void dfs(Lesson lesson,Lesson[] lessons){
        List<Integer> list = lesson.in;
        if(list.isEmpty()) return;
        int max = 0;
        for(int i:list){
            for (Integer integer : lessons[i].out) {
                max = Math.max(lessons[integer].floor,max);
            }
            lessons[i].floor = max;
            dfs(lessons[i],lessons);
        }
    }

}
class Lesson{
    List<Integer> in;
    List<Integer> out;
    int floor;
    public Lesson(){
        out = new ArrayList<>();
        in = new ArrayList<>();
    }
}
