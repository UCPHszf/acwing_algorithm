package Math;

public class Prime {
    //check if it's nums
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    //sieve prime num
    public void getPrimeListEratosthenes(int num) {
        int N = 1000010;
        int primes[] = new int[N];
        boolean st[] = new boolean[N];
        int cnt = 0;
        for (int i = 2; i <= num; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                for (int j = i + i; j <= num; j++) st[j] = true;
            }
        }
    }

    public void getPrimeListLinear(int num) {
        int N = 1000010;
        int primes[] = new int[N];
        boolean st[] = new boolean[N];
        int cnt = 0;
        for (int i = 2; i <= num; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= num; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }
}
