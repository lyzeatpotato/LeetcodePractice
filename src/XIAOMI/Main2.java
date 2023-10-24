package XIAOMI;

import java.util.*;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/23 17:00
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String[] dependencies = scan.nextLine().split(",");

        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String progress : dependencies) {
            for (int i = 1; i < num; i++) {
                char process1 = progress.charAt(i - 1);
                char process2 = progress.charAt(i);
                graph.putIfAbsent(process1, new HashSet<>());
                graph.get(process1).add(process2);
            }
        }

        if (isArrangeValid(graph)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isArrangeValid(Map<Character, Set<Character>> graph) {
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();

        for (char process : graph.keySet()) {
            if (!visited.contains(process)) {
                if (!dfsHaveCircle(graph, process, visited, visiting)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfsHaveCircle(Map<Character, Set<Character>> graph, char process,
                              Set<Character> visited, Set<Character> visiting) {
        visiting.add(process);

        if (graph.containsKey(process)) {
            for (char program : graph.get(process)) {
                if (visiting.contains(program)) {
                    return false;   //包含了环说明工序不满足
                }
                if (!visited.contains(process)) {
                    if (!dfsHaveCircle(graph, program, visited, visiting)) {
                        return false;
                    }
                }
            }
        }
        visiting.remove(process);
        visited.add(process);
        return true;
    }
}
