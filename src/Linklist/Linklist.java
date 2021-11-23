package Linklist;

public class Linklist {
    int N = 100010;
    int head, idx;
    int[] elements, next;

    void init() {
        head = -1;
        idx = 0;
        elements = new int[N];
        next = new int[N];
    }

    //new_head(int val)->head->1->2->3->4->...

    void add_to_head(int val) {
        elements[idx] = val;
        next[idx] = head;
        head = idx;
        idx++;
    }

    void add(int val, int offset) {
        elements[idx] = val;
        next[idx] = next[offset];
        next[offset] = idx;
        idx++;
    }

    //将下标offset的点的后一个点删除
    void remove(int offset) {
        next[offset] = next[next[offset]];
    }
}
