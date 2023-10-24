package meituan.t0916;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main5
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/16 20:37
 */
class Edge {
    int u;
    int v;
    int cost;
    int p;

    public Edge(int u, int v, int cost, int p) {
        this.u = u;
        this.v = v;
        this.cost = cost;
        this.p = p;
    }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        List<Edge> plans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            int p = scan.nextInt();
            plans.add(new Edge(u, v, w, p));
        }
        // 按照花费从小到大排序计划
        plans.sort(Comparator.comparingInt(a -> a.cost));

        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int chosenCount = 0;
    }

    public static void getResult(int n, int m, int[][] road) {

    }
}
