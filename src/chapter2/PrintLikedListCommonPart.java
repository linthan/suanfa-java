package chapter2;

public class PrintLikedListCommonPart {

  public static void main(String[] args) {
    PrintLikedListCommonPart printLikedListCommonPart = new PrintLikedListCommonPart();
    int[] arr1 = {
      1, 2, 3, 4, 6, 7, 8, 9,
    };
    int[] arr2 = {2, 3, 5, 6, 7, 8, 9, 12};
    Node head1 = Node.createListNode(arr1);
    Node head2 = Node.createListNode(arr2);
    printLikedListCommonPart.printCommonPart(head1, head2);
  }

  // printCommonPart 打印公共区域
  public void printCommonPart(Node head1, Node head2) {
    System.out.print("Common Part:");
    while (head1 != null && head2 != null) {
      if (head1.value < head2.value) {
        head1 = head1.next;
      } else if (head1.value > head2.value) {
        head2 = head2.next;
      } else {
        System.out.print(head1.value + " ");
        head1 = head1.next;
        head2 = head2.next;
      }
    }
  }
}
