package Graph.Bipartitegraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StainingMethod {
    final int MaxN = 510;
    List<Integer>[] adjacentList;
    int color[] = new int[MaxN];
    int n;

    boolean bfs() {
        for (int i = 0; i < n; i++) {
            if (adjacentList[i].size() > 0 && color[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int j = 0; j < adjacentList[u].size(); j++) {
                        int v = adjacentList[u].get(j);
                        if (color[v] != 0 && color[v] == color[u]) return false;
                        if (color[v] == 0) {
                            color[v] = 3 - color[u];
                            q.add(v);
                        }
                    }
                }
            }
        }
        return true;
    }
}
