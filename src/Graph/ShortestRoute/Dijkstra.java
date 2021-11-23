package Graph.ShortestRoute;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static int[] shortestRoute(int N,int[][]f) {
        int[]dist=new int[N];
        boolean[]visit=new boolean[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        for (int i = 0; i < N; i++) {
            int t=-1;
            for (int j = 1; j < N; j++) {
                if((!visit[j])&&(t==-1||dist[t]>dist[j])){
                    t=j;
                }
            }
            visit[t]=true;
            for (int j = 0; j < N; j++) {
                dist[j]=Math.min(dist[j],dist[t]+f[t][j]);
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] f = new int[N][N];
        for (int[] arr : f) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int M = in.nextInt();
        while (M-- > 0) {
            int start = in.nextInt();
            int end = in.nextInt();
            int distance = in.nextInt();
            f[start][end] = Math.min(f[start][end], distance);
        }
    }
}
