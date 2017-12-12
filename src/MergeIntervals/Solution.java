package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return Integer.compare(o1.end, o2.end);
            }
            return o1.start < o2.start ? -1 : 1;
        });

        List<Interval> merged = new ArrayList<>();
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.start > end) {
                if (start < Integer.MAX_VALUE) {
                    merged.add(new Interval(start, end));
                }
                start = interval.start;
                end = interval.end;
            } else {
                if (start > interval.start)
                    start = interval.start;
                if (end < interval.end)
                    end = interval.end;
            }
        }
        if (start < Integer.MAX_VALUE) {
            merged.add(new Interval(start, end));
        }

        return merged;
    }
}

/**
 * Definition for an interval.
 */
class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}