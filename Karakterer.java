// Last edited 24-02-2020
import edu.princeton.cs.algs4.*;
import java.util.*;

public class Karakterer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextLine();
            String[] split = grades[i].split(" ");
            grades[i] = split[1] + " " + split[0];
        }

        for (int i = 0; i < n; i++) {
            String[] split = grades[i].split(" ");
            if (split[0].length() > 1) {
                if (split[0].charAt(1) == 'X') {
                    String after = grades[i].substring(2);
                    grades[i] = "G" + after;
                } else if (split[0].charAt(0) == 'F' && split[1].charAt(1) != 'X') {
                    String after = grades[i].substring(1);
                    grades[i] = "H" + after;
                }
            }
            else if(split[0].charAt(0) == 'F'){
                String after = grades[i].substring(1);
                grades[i] = "H" + after;
            }
        }

        for(int i = 0; i < n; i++){
            int temp = 0;
            String[] split = grades[i].split(" ");
            String onlyGrade = split[0];
            String onlyName = split[1];
            for(int j = 1; j < onlyGrade.length(); j++){
                if(onlyGrade.charAt(j) == '+'){
                    temp++;
                }
                else if(onlyGrade.charAt(j) == '-'){
                    temp--;
                }
            }
            if(temp > 0){
                grades[i] = onlyGrade.substring(0,1) + "A" + (10-temp) + " " + onlyName;
            }

            else if(temp == 0) {
                grades[i] = onlyGrade.substring(0,1) + "B" + temp + " " + onlyName;
            }
            else {
                temp = temp * -1;
                if(temp >= 10){
                    grades[i] = onlyGrade.substring(0,1) + "C" + "A" + (temp - 10) + " " + onlyName;
                }
                else {
                    grades[i] = onlyGrade.substring(0, 1) + "C" + temp + " " + onlyName;
                }
            }

        }

        Insertion.sort(grades);

        for(int i = 0; i < n; i++){
            //System.out.println(grades[i]);
            System.out.println(grades[i].split(" ")[1]);
        }
    }
}