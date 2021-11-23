package Graph.MaxFlow;

import java.util.Arrays;
import java.util.Scanner;

public class EK {
    final int N = 1010;
    final int M = 20010;
    int n, m, S, T;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] flow = new int[M];
    int[] ne = new int[M];
    int idx;
    int[] q = new int[N];
    int[] pre = new int[N];
    int[] d = new int[N];
    boolean[] st = new boolean[N];
    int MAX = Integer.MAX_VALUE;

    void addEdge(int start, int end, int capacity) {
        //正向边
        e[idx] = end;
        flow[idx] = capacity;
        ne[idx] = h[start];
        h[start] = idx++;

        //反向边
        e[idx] = start;
        flow[idx] = 0;
        ne[idx] = h[end];
        h[end] = idx++;
    }

    boolean bfs() {
        int head = 0, tail = 0;
        Arrays.fill(st, false);
        q[0] = S;
        st[S] = true;
        d[S] = MAX;
        while (head <= tail) {
            int t = q[head++];
            for (int i = h[t]; i != ~i; i = ne[i]) {
                int ver = e[i];
                if (!st[ver] && flow[i] >= 0) {
                    st[ver] = true;
                    d[ver] = Math.min(d[t], flow[i]);
                    if (ver == T) return true;
                }
            }
        }
        return false;
    }

    int EK() {
        int r = 0;
        while (bfs()) {
            r += d[T];
            for (int i = T; i != S; i = e[pre[i] ^ 1]) {
                flow[pre[i]] -= d[T];
                flow[pre[i] ^ 1] += d[T];
            }
        }
        return r;
    }

    void init() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        S = in.nextInt();
        T = in.nextInt();
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            addEdge(a, b, c);
        }
    }
}
