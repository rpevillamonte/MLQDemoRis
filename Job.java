import java.lang.Comparable;

public class Job implements Comparable{
    
    private String processName;
    private int arrivalTime, burstTime, priority;
    private int waitingTime;

    // for when priority is not needed
    public Job(String processName, int arrivalTime, int burstTime) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    public Job(String processName, int arrivalTime, int burstTime, int priority) {
        this(processName, arrivalTime, burstTime);
        this.priority = priority;
    }

    public String toString() {
        return String.format("[%s] Arrival Time: %d, Burst Time: %d, Waiting Time: %d", processName, arrivalTime, burstTime, waitingTime);
    }

    public String processBlock() {
        return String.format("[%s]", processName);
    }

    public void setWaitingTime(int currentTime) {
        this.waitingTime = Math.abs(currentTime-arrivalTime);
    }

    public int getWaitingtime() { return waitingTime; }

    public void quantum(int quantumSlice) {
        this.burstTime -= quantumSlice;
    }

    @Override
    public int compareTo(Object o) {
        return (this.arrivalTime < ((Job) o).arrivalTime) ? -1 : (this.arrivalTime == ((Job) o).arrivalTime ? 0 : 1);
    }

    public int getArrTime() { return arrivalTime; }

    public int getBurstTime() { return burstTime; }

    public int getPriority() { return priority; }
}
