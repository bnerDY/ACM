/**
 * Created by Martin on 15/11/2015.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lesson11 {
    //Sieve of Eratosthenes.
    /**
     * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
     A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
     You are given two non-empty zero-indexed arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
     Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
     For example, consider an integer N = 26 and arrays P, Q such that:
     P[0] = 1    Q[0] = 26
     P[1] = 4    Q[1] = 10
     P[2] = 16   Q[2] = 20
     The number of semiprimes within each of these ranges is as follows:

     (1, 26) is 10,
     (4, 10) is 4,
     (16, 20) is 0.
     * @param N
     * @param P
     * @param Q
     * @return
     */

    public int[] countSemiPrimes(int N, int[] P, int[] Q){
        boolean[] sieve = new boolean[N+1];
        Arrays.fill(sieve, Boolean.TRUE);
        sieve[0] = false;
        sieve[1] = false;
        for(int i=2; i<(int)(Math.sqrt(N)+1); i++) {
            if(sieve[i]) {
                for(int j=i+i; j<N; j+=i) {
                    sieve[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        for(int i=0; i<sieve.length; i++) {
            if(sieve[i]) {
                primes.add(i);
            }
        }
        int[] semiprimes = new int[N+1];
        int[] sp = new int[N+1];
        long semiprime = 0;
        for(int i=0; i<primes.size(); i++) {
            for(int j=i; j<primes.size(); j++) {
                semiprime = (long)primes.get(i)*(long)primes.get(j);
                if(semiprime>N) {
                    break;
                }
                semiprimes[(int)semiprime] = 1;
                sp[(int)semiprime] = 1;
            }
        }
        for(int i=1; i<semiprimes.length; i++) {
            semiprimes[i] += semiprimes[i-1];
        }
        int[] count = new int[Q.length];
        for(int i=0; i<Q.length; i++) {
            count[i] = semiprimes[Q[i]] - semiprimes[P[i]] + sp[P[i]];
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
