package leetcode.offer;

public class test02 {
    public void merge(ListNode A, ListNode B, ListNode C) {
        ListNode h1 = A, h2 = B, h3 = C;
        for (; h1 != null; h1 = h1.next) {
            for (; h2 != null; h2 = h2.next) {
                if (h1.val == h2.val) break;
            }
            h3 = new ListNode(h1.val);
            h3 = h3.next;
        }
    }

}
