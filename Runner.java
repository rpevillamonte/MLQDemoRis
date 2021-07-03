import java.util.ArrayList;
import java.util.Random;


public class Runner {
    
    public static void main(String[] args) {

        ArrayList<Job> jobs = new ArrayList<Job>();
        Random rd = new Random();

        for(int i=0; i<30; i++) {
            Job newJob = new Job("P"+Integer.toString(i), rd.nextInt(31), rd.nextInt(51), rd.nextInt(3) + 1);
            jobs.add(newJob);
        }   

        ArrayList<Job> firstPrio = new ArrayList<Job>();
        ArrayList<Job> secondPrio = new ArrayList<Job>();
        ArrayList<Job> thirdPrio = new ArrayList<Job>();

        for (Job job : jobs) {
            if(job.getPriority() == 1) firstPrio.add(job);
            else if(job.getPriority() == 2) secondPrio.add(job);
            else thirdPrio.add(job);
        }

        //FCFS fc = new FCFS(jobs);
        //fc.process();
        //fc.showGantt();
//
        //RoundRobin rr = new RoundRobin(jobs, 5);
        //rr.process();
        //rr.showGantt();

        //MLQ Demonstration for Three Process Queues
        MLQ fMLQ = new MLQ(firstPrio, 1);
        fMLQ.process();
        MLQ sMLQ = new MLQ(secondPrio, 2);
        sMLQ.process();
        MLQ tMLQ = new MLQ(thirdPrio, 3);
        tMLQ.process();
    }

}
