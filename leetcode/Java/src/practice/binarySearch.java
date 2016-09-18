package practice;

/**
 * Created by Martin on 17/09/2016.
 */
public class binarySearch {
    public int binarySearch(int a[], int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int binarySearchRecursive(int a[],int low, int high, int key){
        if(low > high)
            return -1;

        int mid = low + (high - low)/2;
        if(key < a[mid])
            return binarySearchRecursive(a, low, mid - 1, key);
        else if(key > a[mid])
            return binarySearchRecursive(a, mid + 1, high, key);
        else
            return mid;

    }

    public int binarySearchRecursive(int a[], int key){
        return binarySearchRecursive(a, 0, a.length-1, key);
    }

}
