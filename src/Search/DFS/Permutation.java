package Search.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation {
    private static int n;
    private static boolean visit[];
    public static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        visit = new boolean[n + 1];
        dfs(0, new StringBuilder());
        for (String s : res) System.out.println(s);
    }

    public static void dfs(int u, StringBuilder path) {
        if (u == n) {
            res.add(path.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                path.append(i);
                visit[i] = true;
                dfs(u + 1, path);
                visit[i] = false;
                path.delete(path.length() - String.valueOf(i).length(), path.length());
            }
        }
    }
}
