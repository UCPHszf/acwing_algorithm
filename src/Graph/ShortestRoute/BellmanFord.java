package Graph.ShortestRoute;

import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {

    static class Edge {
        int start;
        int end;
        int distance;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static int[] bellmanFord(int N, int K, Edge[] edges) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] backup = new int[N];
        for (int i = 0; i < K; i++) {
            System.arraycopy(dist, 0, backup, 0, edges.length);
            for (int j = 0; j < edges.length; j++) {
                int start = edges[j].start, end = edges[j].end, distance = edges[j].distance;
                dist[end] = Math.min(backup[start] + distance, dist[end]);
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            int d = in.nextInt();
            edges[i] = new Edge(s, e, d);
        }
        int[] res = bellmanFord(N, K, edges);
        for (Integer i : res) {
            System.out.println(res);
        }
    }
}
