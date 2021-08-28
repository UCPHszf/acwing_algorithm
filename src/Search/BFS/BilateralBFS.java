package Search.BFS;

import java.util.*;

public class BilateralBFS {
    private static final int N = 6;
    static int n = 0;
    static String a[];
    static String b[];

    int bfs(String A, String B) {
        Queue<String> queueA = new LinkedList<>();
        Queue<String> queueB = new LinkedList<>();
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        queueA.add(A);
        queueB.add(B);
        mapA.put(A, 0);
        mapB.put(B, 0);
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            int t;
            if (queueA.size() < queueB.size()) {
                t = extend(queueA, mapA, mapB, a, b);
            } else {
                t = extend(queueB, mapB, mapA, b, a);
            }
            if (t <= 10) return t;
        }
        return 11;
    }

    private int extend(Queue<String> queue, Map<String, Integer> curSide,
                       Map<String, Integer> otherSide, String[] a, String[] b) {
        String str = queue.poll();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < n; j++) {
                if (str.substring(i, i + a[j].length()) == a[j]) {
                    String state = str.substring(0, i) + b[j] + str.substring(i + a[j].length());
                    if (otherSide.containsKey(state)) {
                        return curSide.get(str) + 1 + otherSide.get(state);
                    }
                    if (curSide.containsKey(state)) continue;
                    curSide.put(state, curSide.get(str) + 1);
                    queue.add(state);
                }
            }
        }
        return 11;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
    }
}
