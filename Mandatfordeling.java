// Last edited 01-03-2020
import edu.princeton.cs.algs4.*;
import java.util.Scanner;

class Quotient implements Comparable<Quotient>{
    double quotient;
    int id;
    public Quotient(double quotient, int id){
        this.quotient = quotient;
        this.id = id;
    }

    @Override
    public int compareTo(Quotient that) {
        if(this.quotient < that.quotient){
            return -1;
        }
        else if(this.quotient > that.quotient){
            return +1;
        }
        else {
            return 0;
        }
    }
}

public class Mandatfordeling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] seatsPerParty = new int[n];
        int[] votesPerParty = new int[n];
        MaxPQ<Quotient> priorityQueue = new MaxPQ<>();

        for (int i = 0; i < n; i++) {
            int votes = scanner.nextInt();
            votesPerParty[i] = votes;
            priorityQueue.insert(new Quotient(votes,i));
        }

        for (int j = 0; j < m; j++) {
            int maxid = priorityQueue.delMax().id;
            seatsPerParty[maxid]++;
            double newQuotient = votesPerParty[maxid] / (seatsPerParty[maxid] + 1.0);
            priorityQueue.insert(new Quotient(newQuotient,maxid));
        }

        for (int i : seatsPerParty) {
            System.out.println(i);
        }
    }
}