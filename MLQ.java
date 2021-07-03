//Demonstration with 3 process queues

import java.util.ArrayList;

public class MLQ extends SchedulingAlgo{
 
    private ArrayList<Job> jobs;
    private int algo;
    private SchedulingAlgo p_algo;

    public MLQ(ArrayList<Job> jobs, int algo) {
        this.algo = algo;
        this.jobs = jobs;
        if(algo == 1 || algo == 3) {
            p_algo = new FCFS(jobs);
        } else {
            p_algo = new RoundRobin(jobs, 5);
        }
    }

    @Override
    public void process() {
        p_algo.process();
        p_algo.showGantt();
    }

    @Override
    public void showGantt() {
        
    }
}
