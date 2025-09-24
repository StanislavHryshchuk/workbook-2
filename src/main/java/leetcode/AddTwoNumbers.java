//package leetcode;
//
//public class AddTwoNumbers {
//
//    public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
//
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode newNode = new ListNode(0);
//
//        ListNode curr1 = l1;
//        ListNode curr2 = l2;
//
//        while (curr1.next != null){
//
//            while(curr2.next != null){
//                newNode.val = curr1.val + curr2.val;
//                if(newNode.val > 10){
//                    newNode.val = 0;
//                    newNode.next = new ListNode(1);
//                }
//
//                curr2 = curr2.next;
//            }
//            curr1 = curr1.next;
//        }
//        return newNode;
//    }
//}
