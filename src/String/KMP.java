package String;

public class KMP {
    public boolean KMPMatch() {
        return true;
    }

    public int[] getNext(String str) {
        int[] next = new int[str.length()];
        for (int i = 2, j = 0; i <= str.length(); i++) {
            while (j != 0 && str.charAt(i) != str.charAt(j + 1)) {
                j = next[j];
            }
            if (str.charAt(i) == str.charAt(j + 1)) j++;
            next[i] = j;
        }
        return next;
    }
}
