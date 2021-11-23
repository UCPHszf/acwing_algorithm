package Math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DividePrime {
    public List<Integer> primeList(int num) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i < Math.ceil(Math.sqrt(num)); i++) {
            while (num % i == 0) {
                num /= i;
                res.add(i);
            }
        }
        if (num > 1) res.add(num);
        return res;
    }

    @Test
    public void testPrimeList() {
        System.out.println(primeList(1775624));
    }
}
