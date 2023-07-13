package leetcode.offer;

import java.util.PriorityQueue;

public class p059 {
    public static void main(String[] args) {
        int arr[] = new int[]{4, 6, 3, 4, 5, 7, 976, 65, 5};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        System.out.println(queue.peek());
    }
}

class KthLargest {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
