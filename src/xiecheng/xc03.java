package xiecheng;

import java.util.*;

public class xc03 {
    static int n, l, r;
    static int[] values;
    static Map<Integer, List<Integer>> tree;
    static Map<Integer, Integer> binaries;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        values = new int[n+1];
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.valueOf(chars[i]);
        }
        tree = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            if (!tree.containsKey(u)) {
                tree.put(u, new ArrayList<>());
            }
            if (!tree.containsKey(v)) {
                tree.put(v, new ArrayList<>());
            }
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        binaries = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dfs(i, -1, new ArrayList<>(Arrays.asList(i)), values, binaries);
        }

        long count = 0;
        List<Integer> sortedBinaries = new ArrayList<>(binaries.keySet());
        Collections.sort(sortedBinaries);
        for (int binary : sortedBinaries) {
            if (binary >= l && binary <= r) {
                count += binaries.get(binary);
            }
        }

        System.out.println(count);
    }

    static void dfs(int node, int parent, List<Integer> path, int[] values, Map<Integer, Integer> binaries) {
        int pathValue = 0;
        for (int i = 0; i < path.size(); i++) {
            pathValue += values[path.get(i)] * (1 << i);
        }
        binaries.put(pathValue, binaries.getOrDefault(pathValue, 0) + 1);

        for (int child : tree.get(node)) {
            if (child != parent) {
                List<Integer> childPath = new ArrayList<>(path);
                childPath.add(child);
                dfs(child, node, childPath, values, binaries);
            }
        }
    }
}