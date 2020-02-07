import java.util.*;

 class Job {
    private int taskID, deadline, profit;

    public Job(int taskID, int deadline, int profit) {
        this.taskID = taskID;
        this.deadline = deadline;
        this.profit = profit;
    }
    public int getDeadline() { return deadline; }
    public int getProfit() { return profit; }
    public int getTaskID() { return taskID; }
 }

 class JobSequencing {
    public static int scheduleJobs(List<Job> jobs, int T) {
        int profit = 0;
        int[] slot = new int[T];
        Arrays.fill(slot, -1);
        for (Job job : jobs) {
            for (int j = job.getDeadline() - 1; j >= 0; j--) {
                if (j < T && slot[j] == -1) {
                    slot[j] = job.getTaskID();
                    profit += job.getProfit();
                    break;
                }
            }
        }
        System.out.println("The Scheduled jobs to get Maximum Profit - ");
        Arrays.stream(slot).filter(val -> val != -1).forEach(System.out::println);
        return profit;
    }

     public static void main(String[] args) {
         List<Job> jobs = Arrays.asList(
             new Job(1, 2, 100), new Job(2, 1, 19),
             new Job(3, 2, 27), new Job(4, 1, 25),
             new Job(5, 3, 15)
             );
         final int T = 15;
         Collections.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());
         System.out.println("Total Profit is: " + scheduleJobs(jobs, T));
         }
     }