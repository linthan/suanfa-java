package chapter2;

public class DeleteLastKNode {

  public static void main(String[] args) {
    DeleteLastKNode deleteLastKNode = new DeleteLastKNode();
    int[] arr = {
      1, 2, 3, 4, 6, 7, 8, 9,
    };

    Node head1 = Node.createListNode(arr);
    DoubleNode head2 = DoubleNode.createListNode(arr);
    head1 = deleteLastKNode.removeLastKthNode(head1, 3);
    head2 = deleteLastKNode.removeLastKthDoubleNode(head2, 3);
    Node.printNode(head1);
    System.out.println();
    DoubleNode.printNode(head2);
  }

  public Node removeLastKthNode(Node head, int lastKth) {
    if (head == null || lastKth < 1) {
      return head;
    }
    Node cur = head;
    while (cur != null) {
      lastKth--;
      cur = cur.next;
    }
    if (lastKth == 0) {
      head = head.next;
    }
    if (lastKth < 0) {
      cur = head;
      while (++lastKth != 0) {
        cur = cur.next;
      }
      cur.next = cur.next.next;
    }
    return head;
  }

  public DoubleNode removeLastKthDoubleNode(DoubleNode head, int lastKth) {
    if (head == null || lastKth < 1) {
      return head;
    }
    DoubleNode cur = head;
    while (cur != null) {
      lastKth--;
      cur = cur.next;
    }
    if (lastKth == 0) {
      head = head.next;
      head.last=null;
    }
    if (lastKth < 0) {
      cur = head;
      while (++lastKth != 0) {
        cur = cur.next;
      }
      DoubleNode newNext = cur.next.next;
      cur.next = newNext;
      if (newNext != null) {
        newNext.last = cur;
      }
    }
    return head;
  }
}
