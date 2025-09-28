import java.util.Arrays;


public class DeterministicSelect {
    public int select(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }


        int pivot = pivot(arr, left, right);
        int partitionIndex = partition(arr, left, right, pivot);


        int length = partitionIndex - left + 1;
        if (k == length)
            return arr[partitionIndex];
        else if (k < length)
            return select(arr, left, partitionIndex - 1, k);
        else
            return select(arr, partitionIndex + 1, right, k - length);
    }


    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left - 1;
    }


    private int pivot(int[] arr, int left, int right) {
        if (right - left < 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[(left + right) / 2];
        }
        for (int i = left; i <= right; i += 5) {
            int subRight = Math.min(i + 4, right);
            Arrays.sort(arr, i, subRight + 1);
            int median = i + (subRight - i) / 2;
            int temp = arr[left + (i - left) / 5];
            arr[left + (i - left) / 5] = arr[median];
            arr[median] = temp;
        }
        return pivot(arr, left, left + (int) Math.ceil((right - left) / 5.0) - 1);
    }
}