// Last edited 07-03-2020
import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class Flyafgange {

    public static void main(String[] args) {
        ST<Integer,String> symbolTable = new ST<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());

        for (int i = 0; i < n; i++){
            String[] timeSplit = scanner.next().split(":");
            String destination = scanner.next();
            int timeInSeconds = Integer.parseInt(timeSplit[0]) * 3600 + Integer.parseInt(timeSplit[1]) * 60 + Integer.parseInt(timeSplit[2]);
            symbolTable.put(timeInSeconds,destination);
        }

        for(int i = 0; i < m; i++){
            String operation = scanner.next();
            String[] timeSplit = scanner.next().split(":");
            int timeInSeconds = Integer.parseInt(timeSplit[0]) * 3600 + Integer.parseInt(timeSplit[1]) * 60 + Integer.parseInt(timeSplit[2]);

            switch (operation){
                case "destination":
                    String desti = symbolTable.get(timeInSeconds);
                    if(desti != null) {
                        System.out.println(symbolTable.get(timeInSeconds));
                    }
                    else{
                        System.out.println("-");
                    }
                    break;
                case "delay":
                    if(symbolTable.contains(timeInSeconds)) {
                        int delayTime = Integer.parseInt(scanner.next());
                        String tempDestination = symbolTable.get(timeInSeconds);
                        symbolTable.remove(timeInSeconds);
                        symbolTable.put(timeInSeconds + delayTime, tempDestination);
                    }
                    break;
                case "cancel":
                    if(symbolTable.contains(timeInSeconds)) {
                        symbolTable.remove(timeInSeconds);
                    }
                    break;
                case "next":
                    System.out.println(symbolTable.get(symbolTable.ceiling(timeInSeconds)));
                    break;
                case "count":
                    int count  = 0;
                    String[] otherTimeSplit = scanner.next().split(":");
                    int otherTimeInSeconds = Integer.parseInt(otherTimeSplit[0]) * 3600 + Integer.parseInt(otherTimeSplit[1]) * 60 + Integer.parseInt(otherTimeSplit[2]);
                    if(!symbolTable.isEmpty()) {
                        int max = symbolTable.floor(otherTimeInSeconds);
                        int time = symbolTable.ceiling(timeInSeconds);
                        while (time <= max) {
                            count++;
                            if(time < symbolTable.max()) {
                                time = symbolTable.ceiling(time + 1);
                            }
                            else {
                                break;
                            }
                        }
                    }
                    System.out.println(count);
                    break;
                case "reroute":
                    if(symbolTable.contains(timeInSeconds)) {
                        symbolTable.put(timeInSeconds,scanner.next());
                    }
                    break;
            }
        }
    }
}