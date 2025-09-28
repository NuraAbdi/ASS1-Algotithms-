# Assignment – Design and Analysis of Algorithms

## 1. Implemented Algorithms
In this project, I implemented four classic divide-and-conquer algorithms:
- **MergeSort** – with reusable buffer and a switch to Insertion Sort for small arrays.
- **QuickSort** – with randomized pivot and recursion only on the smaller subarray.
- **Deterministic Select (Median of Medians)** – finds the k-th element in O(n).
- **Closest Pair of Points (2D)** – finds the closest pair of points in O(n log n).

There is also a metrics module that measures execution time, recursion depth, and number of comparisons. Results can be exported to CSV.

---

## 2. Design Details
- In QuickSort, recursion is always applied to the smaller subarray to keep the stack depth around O(log n).
- MergeSort uses one global buffer to avoid extra memory allocations.
- A cutoff to Insertion Sort is used in MergeSort, which is faster for small inputs.
- Closest Pair of Points is solved with the classic "divide + strip check" approach, where only a few neighbors are checked.

---

## 3. Recurrence Analysis
- **MergeSort:**  
  T(n) = 2T(n/2) + Θ(n) → Θ(n log n).

- **QuickSort (average case):**  
  T(n) = T(n/2) + Θ(n) → Θ(n log n).  
  Worst case: Θ(n²).

- **Deterministic Select:**  
  T(n) = T(n/5) + T(7n/10) + Θ(n) → Θ(n).

- **Closest Pair:**  
  T(n) = 2T(n/2) + Θ(n) → Θ(n log n).

---

## 4. Experimental Results
I tested the algorithms on arrays of different sizes.
- **Time vs n:** (graph here)
- **Depth vs n:** (graph here)

### Observations:
- MergeSort with cutoff is faster for small inputs.
- QuickSort recursion depth grows like log n and stayed small in practice.
- Deterministic Select runs in O(n), but in practice random selection is usually faster.
- Closest Pair results matched theory, but constants dominate for small inputs.

---

## 5. Conclusion
The experiments matched the theoretical complexity.  
On small inputs, constants (JVM, memory allocations, cache effects) have a big influence.  
Randomized QuickSort worked very reliably.  
Deterministic Select guarantees O(n), but is not always the fastest in practice.

---

## 6. Git Workflow
I used separate branches for each part:
- `feature/mergesort`
- `feature/quicksort`
- `feature/select`
- `feature/closest`
- `feature/metrics`

Finally, all branches were merged into `main`, and the release version was tagged as **v1.0**.

---

## 7. Testing
- MergeSort and QuickSort were tested on random and worst-case inputs.
- QuickSort recursion depth stayed within O(log n).
- Select was compared with the result of `Arrays.sort()[k]`.
- Closest Pair was checked against the brute force O(n²) algorithm for small inputs (up to 2000 points).  
