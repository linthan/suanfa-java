package chapter2;

// ReverseNode 翻转node
public class ReverseNode {

  public static void main(String[] args) {
    ReverseNode reverseNode = new ReverseNode();
    int[] arr1 = {
      1, 2, 3, 4, 6, 7, 8, 9,
    };
    int[] arr2 = {2, 3, 5, 6, 7, 8, 9, 12};
    Node head1 = Node.createListNode(arr1);
    DoubleNode head2 = DoubleNode.createListNode(arr2);
    head1 = reverseNode.reverseList(head1);
    head2 = reverseNode.reverseList(head2);
    Node.printNode(head1);
    System.out.println();
    DoubleNode.printNode(head2);
  }

  public Node reverseList(Node head) {
    Node pre = null;
    Node next;
    while (head != null) {
      next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }

  public DoubleNode reverseList(DoubleNode head) {
    DoubleNode pre = null;
    DoubleNode next;
    while (head != null) {
      next = head.next;
      head.next = pre;
      head.last = next;
      pre = head;
      head = next;
    }
    return pre;
  }
}
