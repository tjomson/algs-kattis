// Last edited 13-05-2020
import java.util.ArrayList;
import java.util.Scanner;

public class ØSmitte {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        int R = Integer.parseInt(firstLine[0]);
        int C = Integer.parseInt(firstLine[1]);
        boolean humanInfected = false;

        int[] fields = new int[C];

        //for (int i = 0; i < R; i++) {
            String line = scanner.nextLine();
            String[] strings = line.split("");
            for (int j = 0; j < C; j++) {
                fields[j] = Integer.parseInt(strings[j]);
            }
     //   }
        ArrayList<Integer> virusFields = new ArrayList<>();

        while (!humanInfected && virusCanMove(fields, C, virusFields)) {

            for (Integer i : virusFields) {
                if (i == 0) {
                    if (fields[i + 1] == 3) {
                        humanInfected = true;
                        break;
                    }
                    if (fields[i + 1] != 0) {
                        fields[i + 1] = 2;
                    }
                } else if (i == C-1) {
                    if (fields[i - 1] == 3) {
                        humanInfected = true;
                        break;
                    }
                    if (fields[i - 1] != 0) {
                        fields[i - 1] = 2;
                    }
                } else {
                    if (fields[i + 1] == 3 || fields[i - 1] == 3) {
                        humanInfected = true;
                        break;
                    }

                    if (fields[i + 1] != 0) {
                        fields[i + 1] = 2;
                    }
                    if (fields[i - 1] != 0) {
                        fields[i - 1] = 2;
                    }
                }
            }

            virusFields.clear();
        }

        if (humanInfected) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean virusCanMove(int[] fields, int C, ArrayList<Integer> virusFields) {
        for (int i = 0; i < C; i++) {
            if (fields[i] == 2) {
                virusFields.add(i);
                if (i == 0) {
                    if (fields[i + 1] == 1 || fields[i + 1] == 3) {
                        return true;
                    }
                } else if (i == C - 1) {
                    if (fields[i - 1] == 1 || fields[i - 1] == 3) {
                        return true;
                    }
                } else {
                    if (fields[i - 1] == 1 || fields[i - 1] == 3 || fields[i + 1] == 1 || fields[i + 1] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

