package Graph.Topology;

import org.junit.Test;

import java.util.*;

public class TopologySort {

    public static List<Integer> getTopologySerial(int M, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegrees = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adjList.get(a).add(b);
            inDegrees[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            res.add(t);
            for (Integer i : adjList.get(t)) {
                inDegrees[i]--;
                if (inDegrees[i] == 0)
                    q.add(i);
            }
        }
        if (res.size() < M) res.clear();
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] edges = new int[N][2];
        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }
        List<Integer> serial = getTopologySerial(M, edges);
        for (Integer i : serial) {
            System.out.println(i);
        }
    }
}
