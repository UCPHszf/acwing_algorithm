package Search.DFS;

public class Trie {
    public static final int N = 100010;
    int[][] son = new int[N][26];
    int[] cnt = new int[N];
    int idx = 0;

    void insert(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }

    int query(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
