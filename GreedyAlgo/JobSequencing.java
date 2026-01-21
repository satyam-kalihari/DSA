package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;

// Given an array of jobs where every job has a deadline and profit if the job is finished
// before the deadline. It is also given that every job takes a single unit of time, so the
// minimum possible deadline for any job is 1. Maximize the total profit if only one job can
// be scheduled at a time.
public class JobSequencing {
    
    public static class Job {
    
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int task[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < task.length; i++) {
            jobs.add(new Job(i, task[i][0], task[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit-a.profit);

        ArrayList<Integer> profit = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < task.length; i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                profit.add(curr.profit);
                time++; 
            }
        }

        System.out.println(profit);
    }
}
