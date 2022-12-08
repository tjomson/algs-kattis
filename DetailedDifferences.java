// Last edited 26-01-2020
import java.util.Scanner;

public class DetailedDifferences {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < numberOfTestCases; i++){

            String part1 = sc.nextLine();
            String part2 = sc.nextLine();
            System.out.println(part1);
            System.out.println(part2);

            char[] part1Array = part1.toCharArray();
            char[] part2Array = part2.toCharArray();

            for(int p = 0; p < part1Array.length; p++){
                if(part1Array[p] == part2Array[p]){
                    System.out.print(".");
                }
                else{
                    System.out.print("*");
                }
            }

            System.out.println();
        }
    }
}
