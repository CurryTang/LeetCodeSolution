public class Problem2{
    public ListNode twoSum(ListNode l1, ListNode l2){
        ListNode p1 = l1, p2 = l2;
        int len1 = 0, len2 = 0;
        while(p1 != null){
            p1 = p1.next;
            len1 = len1 + 1;
        }
        while(p2 != null){
            p2 = p2.next;
            len2 = len2 + 1;
        }
        for(int i = 0;i < len2 - len1;i++){
            ListNode ln = new ListNode(0);
            ln.next = l1;
            l1 = ln;
        }
        for(int i = 0;i < len1 - len2;i++){
            ListNode ln = new ListNode(0);
            ln.next = l2;
            l2 = ln;
        }
        int length = (len2 > len1) ? (len2) : (len1);
        p1 = l1;
        p2 = l2;
        int offset = 0;
        for(int i = 0;i < length;i++){
            int value = p1.val + p2.val + offset;
            if (value > 10){
                value -= 10;
                offset = 1;
            } else {
                offset = 0;
            }
            p1.val = value;
        }
        p1 = l1.next;
        while(p1 != null){
            ListNode temp = p1.next;
            p1.next = l1;
            l1 = p1;
        }
        return l1;
    }

    public static void traverse(ListNode l){
        System.out.println("The linked list: ");
        while(l != null){
            System.out.print(l.val + " -> ");
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = null;
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;
        Problem2 p2 = new Problem2();
        p2.traverse(p2.twoSum(l1, l2));
    }
}