package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }
}
