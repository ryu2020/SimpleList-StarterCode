import java.util.Iterator;

public class MyList<T> implements SimpleList<T> {

    private int size;
    private ListNode first;
    private ListNode last;

    public static void main (String[] args){
        MyList<String> str = new MyList<String>();
        str.add("2");
        str.add("a");
        //System.out.println(str.get(0));
        //System.out.println(str.get(1));
        str.add(1, "thing");
        System.out.println(str.get(1));
        str.get(2);
    }

    public MyList(){
        size = 0;
        first = new ListNode();
    }

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return(size == 0);
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    public boolean contains(Object o) {
        ListNode current = first;

        for(int i = 0; i < size; i++){
            if (current.getContents().equals(o))
                return true;
            current = current.getNext();
        }

        return false;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     * <p>
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param t element to be appended to this list
     * @return <tt>true</tt> (as specified by Collection)
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */
    public boolean add(T t) {
        if(size == 0){
            //System.out.println("first");
            first.setContents(t);
            last = first;
            size++;
            return true;
        }
        ListNode<T> temp = new ListNode<T>(t);
        //System.out.println(temp);
        last.setNext(temp);

       // System.out.println(last.getNext());
        last = temp;
        size++;

        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this list
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *                                       is not supported by this list
     */
    public boolean remove(Object o) {
        ListNode current = first;

        for(int i = 0; i < size; i++){
            if (current.getContents().equals(o)){
                current.setNext(current.getNext().getNext());
                size--;
                return true;}
            current = current.getNext();
        }

        return false;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */
    public void clear() {
        size = 0;
        first = new ListNode();
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public T get(int index) {
        ListNode current = first;
        for(int i = 0; i < index; i++){
            if(current.getNext() == null){
                throw new IndexOutOfBoundsException();
            }
            current = current.getNext();
        }
        //System.out.println(current);
        return (T) current.getContents();
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws ClassCastException        if the class of the specified element
     *                                   prevents it from being added to this list
     * @throws NullPointerException      if the specified element is null and
     *                                   this list does not permit null elements
     * @throws IllegalArgumentException  if some property of the specified
     *                                   element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public T set(int index, T element) {
        T r = null;
        ListNode current = first;
        for(int i = 1; i < index; i++){
            current = current.getNext();
        }
        System.out.println(current);
        //not sure how to fix this; generic types do not work with instanceof so i have no way of checking before this cast. Will not return the right thing

        r = (T) current.getContents();

        //another generics thing that I can't quite figure out; this call cannot be safely performed because it has not been checked for type agreement

        current.setContents(element);

        return r;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    public void add(int index, T element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            ListNode n = new ListNode(element, first);
            first = n;
            size++;
        }
        else {
            ListNode before = first;
            ListNode next;
            for (int i = 1; i < index; i++) {
                before = before.getNext();
            }
            System.out.println(before);
            ListNode after = before.getNext();
            ListNode<T> insert = new ListNode(element, after);
            before.setNext(insert);
            size++;
        }
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public T remove(int index) {
        ListNode current = first;
        for(int i = 1; i < index; i++){
            current = current.getNext();
        }
        T r = (T) current.getNext().getContents();
        current.setNext(current.getNext().getNext());
        size--;
        return r;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    public int indexOf(Object o) {
        ListNode current = first;
        for(int i = 0; i < size; i++){
            if(current.getContents().equals(o)){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    public ListNode getLast(){
        return last;
    }
}
