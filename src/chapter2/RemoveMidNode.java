package chapter2;

//RemoveMidNode 删除中间节点
public class RemoveMidNode {

    public static void main(String[] args) {
        RemoveMidNode removeMidNode = new RemoveMidNode();
        int[] arr1 = {
                1, 2, 3, 4, 6, 7, 8, 9,
        };
        int[] arr2 = {2, 3, 5, 6, 7, 8, 9, 12};
        Node head1 = Node.createListNode(arr1);
        Node head2 = Node.createListNode(arr2);
        head1=removeMidNode.removeMidNode(head1);
        head2=removeMidNode.removeByRatio(head2,3,8);
        Node.printNode(head1);
        System.out.println();
        Node.printNode(head2);
    }
  public Node removeMidNode(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    if (head.next.next == null) {
      return head.next;
    }
    Node pre = head;
    Node cur = head.next.next;
    while (cur.next != null && cur.next.next != null) {
      pre = pre.next;
      cur = cur.next.next;
    }
    pre.next = pre.next.next;
    return head;
  }

  public Node removeByRatio(Node head, int a, int b) {
    if (a < 1 || a > b) {
      return head;
    }
    int n = 0;
    Node cur = head;
    while (cur != null) {
      n++;
      cur = cur.next;
    }
    n = (int) Math.ceil(((double) (a * n) / (double) b));
    if (n == 1) {
      head = head.next;
    }
    if (n > 1) {
      cur = head;
      while (--n != 1) {
        cur = cur.next;
      }
      cur.next = cur.next.next;
    }
    return head;
  }
}
