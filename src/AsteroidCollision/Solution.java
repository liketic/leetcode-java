package AsteroidCollision;


import java.util.Stack;

class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            // asteroid < 0
            while (true) {
                if (stack.empty()) {
                    stack.push(asteroid);
                    break;
                }
                int top = stack.peek();
                if (top < 0) {
                    stack.push(asteroid);
                } else if (top + asteroid < 0) {
                    stack.pop();
                    continue;
                } else if (top + asteroid == 0) {
                    stack.pop();
                }
                break;
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}