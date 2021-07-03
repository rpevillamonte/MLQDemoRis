import java.util.ArrayList;
import java.util.Collections;

public class FCFS extends SchedulingAlgo{

    private ArrayList<Job> processes;
    private double avgWaitingTime = 0;
    private String gantt = "";

    public FCFS(ArrayList<Job> processes) {
        this.processes = processes;
    }

    @Override
    public void process() {
        // Arrange the Jobs by arrival time
        // Call modified compareTo method in each Job method
        Collections.sort(processes);
        gantt = "";

        int mark = processes.get(0).getArrTime(); // interval in the Gantt Chart

        for (Job job : processes) {
            gantt += Integer.toString(mark);
            job.setWaitingTime(mark);
            mark += job.getBurstTime();
            gantt += job.processBlock() + " ";
        }

        int totalWaitingTime = 0;
        for (Job job : processes) {
            totalWaitingTime += job.getWaitingtime();
        }

        avgWaitingTime = totalWaitingTime/processes.size();

        //System.out.println(gantt);
        //System.out.printf("Average Waiting Time: %.2f", avgWaitingTime);
    }

    @Override
    public void showGantt() { System.out.println(gantt); }
    
}
