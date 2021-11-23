package Math;

import java.util.HashMap;
import java.util.Map;

public class Divisor {
    final int MOD = (int) (1e9 + 7);

    //divisor num
    //assume we have N = (a1)^b1(a2)^b2...(an)^bn, a1,a2...an are all primes,then we have divisor num or N is (b1+1)(b2+1)...(bn+1)
    public int divisorNum(int num) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 2; i < num / i; i++) {
            while (num % i == 0) {
                hash.put(i, hash.getOrDefault(i, 0) + 1);
            }
        }
        if (num > 1) hash.put(num, 1);
        int res = 1;
        for (Integer i : hash.values()) {
            res = res * (i + 1) % MOD;
        }
        return res;
    }

    //divisor sum
    //divisor sum = (a1^0+a1^1+...+a1^b1)(a2^0+a2^1+...+a2^b2)...(an^0+an^1+an^2+...+an^bn)
}
