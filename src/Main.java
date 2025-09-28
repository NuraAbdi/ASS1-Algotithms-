import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {12, 11, 13, 5, 6, 7};


        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length - 1);
        System.out.print("MergeSort result: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();


        int[] arr2 = {10, 7, 8, 9, 1, 5};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr2, 0, arr2.length - 1);
        System.out.print("QuickSort result: ");
        for (int num : arr2) System.out.print(num + " ");
        System.out.println();


        int[] arr3 = {12, 3, 5, 7, 4, 19, 26};
        DeterministicSelect ds = new DeterministicSelect();
        int k = 3;
        int kth = ds.select(arr3, 0, arr3.length - 1, k);
        System.out.println(k + "-th smallest element is " + kth);


        ClosestPair cp = new ClosestPair();
        ClosestPair.Point[] points = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };
        double minDist = cp.closestPair(points);
        System.out.println("The smallest distance is " + minDist);
    }
}