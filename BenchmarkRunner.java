package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        int[] sizes;
        if (args.length > 0) {
            sizes = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        } else {
            sizes = new int[]{100, 1000, 10000, 100000};
        }

        int trials = 5;

        String csvPath = Paths.get("heapsort_bench.csv").toAbsolutePath().toString();
        try (PrintWriter out = new PrintWriter(new FileWriter(csvPath))) {
            out.println("n,median_time_ms,comparisons,swaps,sorted");

            Random rnd = new Random(12345);

            for (int n : sizes) {
                long[] times = new long[trials];
                long comps = 0;
                long swaps = 0;
                boolean sortedAll = true;

                for (int t = 0; t < trials; t++) {
                    int[] arr = rnd.ints(n, 0, 1_000_000).toArray();
                    PerformanceTracker tracker = new PerformanceTracker();
                    HeapSort sorter = new HeapSort(tracker);

                    long start = System.nanoTime();
                    sorter.sort(arr);
                    long end = System.nanoTime();
                    times[t] = (end - start) / 1_000_000; // ms

                    comps += tracker.getComparisons();
                    swaps += tracker.getSwaps();

                    if (!isSorted(arr)) sortedAll = false;
                }

                long medianTime = median(times);
                long avgComps = comps / trials;
                long avgSwaps = swaps / trials;

                out.printf("%d,%d,%d,%d,%b%n", n, medianTime, avgComps, avgSwaps, sortedAll);
                System.out.printf("n=%d median_time_ms=%d sorted=%b comps=%d swaps=%d%n",
                        n, medianTime, sortedAll, avgComps, avgSwaps);
            }
        }

        System.out.println("CSV saved to heapsort_bench.csv");
    }

    private static long median(long[] a) {
        long[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        int m = b.length / 2;
        if (b.length % 2 == 1) return b[m];
        return (b[m - 1] + b[m]) / 2;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) if (arr[i] < arr[i-1]) return false;
        return true;
    }
}


