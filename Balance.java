// Last edited 07-02-2020
import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class Balance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        char[] chars = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        boolean check = true;

        try {
            for (int i = 0; i < n; i++) {

                if (chars[i] == '(' || chars[i] == '[') {
                    stack.push(chars[i]);
                }

                if (chars[i] == ')') {
                    if (stack.pop() != '(') {
                        check = false;
                    }
                }

                if (chars[i] == ']') {
                    if (stack.pop() != '[') {
                        check = false;
                    }
                }
            }
        }
        catch (Exception e){
            check = false;
        }
        if(check && stack.isEmpty()){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
