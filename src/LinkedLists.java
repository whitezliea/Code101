import java.util.List;

public class LinkedLists {

    public static class Reverse_LinkedList_BM01 {

        private class ListNode {
            int val;
            ListNode next = null;

            public ListNode(int val) {
                this.val = val;
            }
        }

        private void PrintList(ListNode list) {
            while (list != null) {
                System.out.print(list.val + " ");
                list = list.next;
            }
            System.out.println();
        }

        private ListNode Init() {
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(3);
            l1.next.next.next = new ListNode(4);

            return l1;
        }

        private ListNode ReverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            int[] a = new int[1000];
            int index = 0;
            while (head != null) {
                a[index] = head.val;
                index++;
                head = head.next;
            }
            ListNode newhead = new ListNode(0);
            ListNode newNode = new ListNode(a[index - 1]);
            newhead.next = newNode;
            for (int i = index - 2; i >= 0; i--) {
                ListNode tmp = new ListNode(a[i]);
                newNode.next = tmp;
                newNode = tmp;
            }
            return newhead.next;
        }

        private ListNode ReverseList2(ListNode head) {
            if (head == null)
                return null;
            ListNode newhead = null; //init
            // 1->2->3->4
            while (head != null) {
                ListNode cur = new ListNode(head.val); // 1

                // 2 -> 3  ==> 3 -> 2
                cur.next = newhead;
                newhead = cur;

                head = head.next; //Next one
            }
            return newhead;
        }

        private ListNode ReverseListBest(ListNode head) {
            /*
            遍历方法：准备当前指针和前序指针
                    遍历每一个节点
                    断掉当前节点的指针，指向前序
            * */
            ListNode newhead = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = newhead;
                newhead = head;
                head = temp;
            }
            return newhead;
        }

        public void Run() {
            ListNode l1 = Init();
            PrintList(l1);
            ListNode l2 = ReverseList2(l1);
            PrintList(l2);
        }

    }

}
