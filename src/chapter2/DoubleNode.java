package chapter2;

public class DoubleNode {
    public int value;
    public DoubleNode next;
    public DoubleNode last;

    public DoubleNode(int data) {
        this.value = data;
    }

    public static DoubleNode createListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoubleNode pre = null;
        DoubleNode head = null;
        for (int i = 0; i < arr.length; i++) {
            DoubleNode curNode = new DoubleNode(arr[i]);
            head = head != null ? head : curNode;
            if (pre != null) {
                pre.next = curNode;
            }
            curNode.last=pre;
            pre = curNode;
        }
        return head;
    }

    public static void printNode(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
