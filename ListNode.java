
public class ListNode<type> {
    private type contents;
    private ListNode next = null;

    public ListNode(){
        this.contents = null;
    }

    public ListNode(type contents){
        this.contents = contents;
    }

    public ListNode(type contents, ListNode next) {
        this.contents = contents;
        this.next = next;
    }

    public type getContents() {
        return contents;
    }

    public void setContents(type contents) {
        this.contents = contents;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


}
