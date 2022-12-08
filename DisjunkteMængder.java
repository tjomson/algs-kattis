// Last edited 31-01-2020
import java.util.Scanner;
import edu.princeton.cs.algs4.UF;

class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        UF uf = new UF(n);

        for(int i = 0; i < m; i++) {
            int operation = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            switch(operation){
                case 0:
                    if(uf.connected(p, q)){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;

                case 1:
                    uf.union(p,q);
                    break;

                case 2:

            }
        }
    }
}
