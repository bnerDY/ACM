package practice;

/**
 * Created by Martin on 17/09/2016.
 */
public class binarySearch {
    public int binarySearch(int a[], int n, int key) {
        int low = 0, high = n - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (key < a[mid])
                high = mid - 1;
            else if (key > a[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    public int binarySearchRecursive(int a[],int low,int high,int key){
        if(low>high)
            return -(low+1);

        int mid=low+(high-low)/2;
        if(key<a[mid])
            return binarySearchRecursive(a,low,mid-1,key);
        else if(key > a[mid])
            return binarySearchRecursive(a,mid+1,high,key);
        else
            return mid;

    }

    public int binarySearchRecursive(int a[],int n,int key){
        return binarySearchRecursive(a,0,n-1,key);
    }

}
