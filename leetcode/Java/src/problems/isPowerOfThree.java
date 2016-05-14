package problems;

/**
 * Created by Martin on 14/05/2016.
 */
public class isPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        while(n > 1){
            if(n %3 != 0) return false;
            n/=3;
        }
        return true;
    }
}
