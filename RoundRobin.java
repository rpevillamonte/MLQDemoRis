import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class RoundRobin extends SchedulingAlgo{
    
    private ArrayList<Job> processes;
    private double avgWaitingTime = 0;
    private Queue<Job> unfinishedJobs;
    private int quantumSlice;
    private String gantt = "";

    public RoundRobin(ArrayList<Job> processes, int quantumSlice) {
        this.processes = processes;
        this.quantumSlice = quantumSlice;
        unfinishedJobs = new PriorityQueue<Job>();
    }

    @Override
    public void process() {

        gantt = "";
        int mark = 0; // interval in the Gantt Chart

        for (Job job : processes) {
            gantt += Integer.toString(mark);
            gantt += job.processBlock() + " ";
            if(job.getBurstTime() > quantumSlice) {
                job.quantum(quantumSlice);
                mark += quantumSlice;
                unfinishedJobs.add(job);
            } else {
                mark += job.getBurstTime();
            }
        }

        while(!unfinishedJobs.isEmpty()) {
            Job job = unfinishedJobs.poll();
            gantt += Integer.toString(mark);
            gantt += job.processBlock() + " ";
            if(job.getBurstTime() > quantumSlice) {
                job.quantum(quantumSlice);
                mark += quantumSlice;
                unfinishedJobs.add(job);
            } else {
                mark += job.getBurstTime();
            }
            
        }

        //int totalWaitingTime = 0;
        //for (Job job : processes) {
        //    totalWaitingTime += job.getWaitingtime();
        //}

        //avgWaitingTime = totalWaitingTime/processes.size();
        //System.out.printf("Average Waiting Time: %.2f", avgWaitingTime);
    }

    @Override
    public void showGantt() { System.out.println(gantt); }
}
