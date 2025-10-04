# HeapSort (Student B)
This repository is part of **Assignment 2**
It contains an implementation of the **HeapSort algorithm** (Student B) with performance tracking, benchmarking, and empirical analysis.

## Overview
HeapSort is a comparison-based, in-place sorting algorithm that uses a binary heap data structure.  
It guarantees **O(n log n)** runtime in the best, average, and worst cases, and requires only **O(1)** extra memory.  
Although not stable, HeapSort is highly reliable and efficient for large datasets.

## Project Structure
src/

├── main/java/

│ ├── algorithms/HeapSort.java

│ ├── metrics/PerformanceTracker.java

│ └── cli/BenchmarkRunner.java

└── test/java/

│  └──algorithms/HeapSortTest.java

└── desighn2.iml

└── heapsort_bench.csv 

└── pom.xml

## heapsort_bench.csv

n, median_time_ms, comparisons, swaps, sorted

100, 0, 1268, 584, true

1000, 0, 19157, 9078, true

10000, 1, 258350, 124175, true

100000, 12, 3250197, 1575068, true

##  Empirical Results

The benchmark results confirm the O(n log n) complexity of HeapSort.

For small inputs (n ≤ 1,000), runtime is negligible (0–1 ms).

For larger inputs, runtime grows as expected with n log n.

Comparisons and swaps increase proportionally with input size.

##  Tests

The test suite validates the correctness of the HeapSort implementation on different input cases:

- **Empty arrays** – verifies that sorting an empty array works correctly.  
- **Single-element arrays** – ensures one element remains unchanged.  
- **Already sorted input** – confirms that an already sorted array stays sorted.  
- **Reverse sorted input** – checks that the algorithm can handle worst-case order.  
- **Arrays with duplicates** – validates that repeated elements are sorted properly.  



