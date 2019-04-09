package chapter2;

public class Josephus {
    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        int[] arr1 = {
                1, 2, 3, 4, 6, 7, 8, 9,
        };
        Node head1 = Node.createCircleNode(arr1);
        head1 = josephus.josephusKill(head1, 3);
        head1 = josephus.josephusKill2(head1, 3);
        System.out.println(head1.value+" ");
    }
  public Node josephusKill(Node head, int m) {
    if (head == null || head.next == head || m < 1) {
      return head;
    }
    Node last = head;
    while (last.next != head) {
      last = last.next;
    }
    int count = 0;
    while (head != last) {
      if (++count == m) {
        last.next = head.next;
        count = 0;
      } else {
        last = last.next;
      }
      head = last.next;
    }
    return head;
  }

  public Node josephusKill2(Node head, int m) {
    if (head == null || head.next == head || m < 1) {
      return head;
    }
    Node cur = head.next;
    int tmp = 1;
    while (cur != head) {
      tmp++;
      cur = cur.next;
    }
    tmp = getLive(tmp, m);
    while (--tmp != 0) {
      head = head.next;
    }
    head.next=head;
    return head;
  }

  public int getLive(int i, int m) {
    if (i == 1) {
      return 1;
    }
    return (getLive(i - 1, m) + m - 1) % i + 1;
  }
}
