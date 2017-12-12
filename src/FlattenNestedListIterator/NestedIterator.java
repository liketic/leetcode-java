package FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> stack;
    private Iterator<NestedInteger> iterator;
    private NestedInteger single;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        if (nestedList != null)
            stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return single.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (true) {
            while (iterator == null || !iterator.hasNext()) {
                if (stack.isEmpty())
                    return false;
                iterator = stack.pop();
            }
            NestedInteger nested = iterator.next();
            if (nested.isInteger()) {
                // cache the next integer because next() cannot call twice
                single = nested;
                return true;
            } else if (nested.getList() != null) {
                // push left elements of iterator and new list to stack
                stack.push(iterator);
                stack.push(nested.getList().iterator());
            }
            // reset iterator for next use
            iterator = null;
        }
    }
}
