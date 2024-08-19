import java.util.Scanner;

class Process {
    int pid; // Process ID
    int arrivalTime; // Arrival time
    int burstTime; // Burst time
    int waitingTime; // Waiting time
    int turnAroundTime; // Turnaround time

    Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Process[] processes = new Process[4];

        // User input for arrival time and burst time
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter Arrival Time and Burst Time for P" + (i + 1) + ": ");
            int arrivalTime = sc.nextInt();
            int burstTime = sc.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        // Calculate waiting time and turnaround time
        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        for (Process process : processes) {
            if (currentTime < process.arrivalTime) {
                currentTime = process.arrivalTime;
            }

            process.waitingTime = currentTime - process.arrivalTime;
            process.turnAroundTime = process.waitingTime + process.burstTime;

            currentTime += process.burstTime;

            totalWaitingTime += process.waitingTime;
            totalTurnAroundTime += process.turnAroundTime;
        }

        // Output table for processes
        System.out.println("\nProcess\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time");
        for (Process process : processes) {
            System.out.println("P" + process.pid + "\t\t" + process.arrivalTime + "\t\t" + process.burstTime + "\t\t" + process.waitingTime + "\t\t" + process.turnAroundTime);
        }

        // Calculating the average waiting time and turnaround time
        double avgWaitingTime = (double) totalWaitingTime / 4;
        double avgTurnAroundTime = (double) totalTurnAroundTime / 4;
        
        // Calculating throughput (number of processes / total time)
        double throughput = 4.0 / (currentTime - processes[0].arrivalTime);

        // Outputting the calculated values
        System.out.println("\nTotal Waiting Time: " + totalWaitingTime);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Total Turn Around Time: " + totalTurnAroundTime);
        System.out.println("Average Turn Around Time: " + avgTurnAroundTime);
        System.out.println("Throughput: " + throughput + " processes/unit time");

        sc.close();
    }
}
