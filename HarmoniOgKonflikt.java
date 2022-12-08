// Last edited 14-03-2020
import edu.princeton.cs.algs4.*;

import java.util.HashMap;
import java.util.Scanner;

public class HarmoniOgKonflikt {

    public static void main(String[] args) {
        if (isHarmonious()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean isHarmonious() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean harmonious = true;

        Graph graph = new Graph(n);
        Boolean[] vertexArray = new Boolean[n];
        //boolean[][] edgeArray = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int c = scanner.nextInt();
            graph.addEdge(u,v);

            /*
            if (c == 1) {
                edgeArray[u][v] = true;
                edgeArray[v][u] = true;
            }
            */
        }

        vertexArray[0] = true;

        for (int i = 0; i < n; i++) {
            Boolean iValue = vertexArray[i];
            if (iValue != null) {
                for (int adjacentVertex : graph.adj(i)) {
                    Boolean adjValue = vertexArray[adjacentVertex];
                    //if (edgeArray[i][adjacentVertex]) {
                        if (adjValue != null) {
                            if (adjValue == vertexArray[i]) {
                                harmonious = false;
                            }
                        } else {
                          vertexArray[adjacentVertex] = !vertexArray[i];
                        }
                   /* } else {
                        if (adjValue != null) {
                            if (adjValue != iValue) {
                                harmonious = false;
                            }
                        } else {
                            vertexArray[adjacentVertex] = iValue;
                        }
                    }*/
                }
            }
        }
        return harmonious;
    }
}
