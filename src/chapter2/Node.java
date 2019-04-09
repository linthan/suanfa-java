package chapter2;

public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public static Node createListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node pre = null;
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
            Node curNode = new Node(arr[i]);
            head = head != null ? head : curNode;
            if (pre != null) {
                pre.next = curNode;
            }
            pre = curNode;
        }
        return head;
    }

    public static Node createCircleNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node pre = null;
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
            Node curNode = new Node(arr[i]);
            head = head != null ? head : curNode;
            if (pre != null) {
                pre.next = curNode;
            }
            pre = curNode;
            if(i==arr.length-1){
                curNode.next=head;
            }
        }
        return head;
    }
    public static void printNode(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
