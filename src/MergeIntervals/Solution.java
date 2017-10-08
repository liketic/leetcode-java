package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end < o2.end ? -1 : (o1.end == o2.end ? 0 : 1);
            }
            return o1.start < o2.start ? -1 : 1;
        });

        List<Interval> ret = new ArrayList<>();
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.start > end) {
                if (start < Integer.MAX_VALUE) {
                    ret.add(new Interval(start, end));
                }
                start = interval.start;
                end = interval.end;
            } else {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }
        }
        if (start < Integer.MAX_VALUE) {
            ret.add(new Interval(start, end));
        }

        return ret;
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