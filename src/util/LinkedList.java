package util;

import java.util.*;

public class LinkedList<E extends Comparable<? super E>>  implements Iterable<E>
{
    private Node<E> head;
    private Node<E> tail;
    private int nodesNR;
    private Comparator<? super E> comparator;

    public LinkedList() {
    }

    public LinkedList(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }


    public LinkedList(LinkedList<E> original) {
        nodesNR = original.size();
        head = original.getHeadNode();
        tail = original.getTailNode();
        comparator = original.comparator();
    }


    public Comparator<? super E> comparator() {
        return comparator;
    }

    public void  setComparator(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    private Node<E> goAtIndex(int index) throws IndexOutOfBoundsException
    {
        Node<E> current = head;

        /*i starts from 1 cuz we start from head and not from before head*/
        int i = 1;
        for ( ; i < index && i < nodesNR; i++ ) current = current.next;

        if ( i == nodesNR) throw new IndexOutOfBoundsException("Index bigger then list size");
        return current;
    }


    public void add(E e){

        /*in case list is empty initialize it*/
        if (head == null)
        {
            head = new Node<E>(e);
            tail = head;
            nodesNR = 1;
            return;
        }

        Node<E> current = head;

        if ( comparator != null){

            while (current!= null) {
                if (comparator.compare(current.data, e) > 0) {
                    break;
                }

                current = current.next;
            }

        }
        else {
            while (current != null) {
                if (current.data.compareTo(e) > 0) {
                    break;
                }
                current = current.next;

            }
        }

        //caught in mid
        if ( current != head && current !=null) {
            current = current.prev;
            addAfter(e, current);

        } else if( current == null){
            //caught last,
            addAfter(e, tail);
            tail = tail.next;
        } else if (current == head){
            //caught first
            if ( comparator != null){

                    if (comparator.compare(current.data, e) > 0) {
                        addHead(e);
                    } else {
                       addAfter(e,head);
                }

            }
            else {
                    if (current.data.compareTo(e) > 0) {
                        addHead(e);
                    } else {

                        addAfter(e,head);

                    }
            }
        }



    }

    private void addAfter(E e, Node<E> after){
        Node<E> aux = new Node<>(e);

        aux.next = after.next;
        after.next = aux;
        aux.prev = after;

        if ( aux.next != null){
            aux.next.prev = aux;
        }
        nodesNR++;

    }

    public void addAll(Collection<? extends E> c){
        for ( E e : c){
            add(e);
        }
    }

    private void addHead(E e){
        Node<E> newHead = new Node<>(e);
        newHead.next = head;
        if ( head != null)
            head.prev = newHead;
        head = newHead;
        if (tail == null) tail = head;

    }

   /* public E get(int index){
        return goAtIndex(index).data;
    }

    public Node<E> getNode(int index){
        return goAtIndex(index);
    }

    public int indexOf(Object e){
        e = (E) e;
        Node current  = getHeadNode();
        if ( current == null) return -1;
        int i = 0;
        for ( ; !current.data.equals(e) && i < nodesNR; i++) current = current.next;

        if ( i == nodesNR) return -1;

        return i;
    }

    public int indexOf(Node<E> node){
        return indexOf(node.data);
    }

    public boolean contains(Object e){ ;
        return indexOf(e) > -1;
    }

    public boolean contains(Node<E> node){
        return indexOf(node) > -1;
    }*/

    public E remove(int index){
        Node<E> current = goAtIndex(index);
        if ( current == null) return null;
        if ( current.next != null)
            current.next.prev = current.prev;
        if ( current.prev != null)
            current.prev.next = current.next;
        return current.data;
    }

    public void remove(E e){
        if ( head == null){
            return;
        } else if ( head.data.equals(e)){
            head = head.next;
            head = null;
            return;
        }

        Node<E> current = head;

        while(!current.data.equals(e)){
            current = current.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if ( current.next != null){
            current.next.prev = current.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        current = null;
    }

    public boolean isEmpty(){
        return nodesNR == 0;
    }

    public boolean removeAll(Collection<E> c){
        for(E e : c) remove(e);
        return true;
    }

    public LinkedList<E> cloneList() {
        return new LinkedList<>(this);
    }

    public int size() {
        return nodesNR;
    }

    private Node<E> getHeadNode() {
        return head;
    }

    private Node<E> getTailNode() {
        return tail;
    }

    public E getHead(){
        return head.data;
    }
    public E getTail(){
        return tail.data;
    }

    public String toString()
    {
        /*return nodesNR + " nodes in list:\n" + head + "\n";*/
        if ( head == null) return "[]";
        return "["+head+"]";
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIteratorImpl(getHeadNode());
    }

    public ListIterator<E> listIterator(){
        return new ListIteratorImpl(getHeadNode());
    }

    public ListIterator<E> listIterator(int index){
        return new ListIteratorImpl(goAtIndex(index));
    }

    private static class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        private Node(E e, Node<E> next, Node<E> prev)
        {
            data = e;
            this.next = next;
            this.prev = prev;

        }

        private Node(E e) {
            this(e, null, null);
        }

        public String toString() {
            if (next == null)
                return data.toString();
            return data + ", " + next;
        }
    }

    private class ListIteratorImpl implements ListIterator<E> {

        private Node<E> inBetween;
        private int index;

        ListIteratorImpl(Node<E> head){
            inBetween = new Node<>(null);
            if ( head != null){
                head.prev = inBetween;
                inBetween.next = head;
                index = -1;
            }

        }

        @Override
        public boolean hasNext() {
            return inBetween.next != null;
        }

        @Override
        public boolean hasPrevious() {
            return inBetween.prev != null;
        }

        @Override
        public E next() {
            inBetween = inBetween.next;
            index++;
            return inBetween.data;
        }

        @Override
        public E previous() {
            index--;
            inBetween = inBetween.prev;
            return inBetween.next.data;
        }

        @Override
        public int nextIndex() {
            if ( hasNext() ) return index + 1;
            return index;
        }

        @Override
        public int previousIndex() {
            return index;
        }

        @Override
        public void add(E e) {
            inBetween.prev =  new Node<>(e,inBetween, inBetween.prev);

        }

        @Override
        public void remove() {
            Node<E> aux = inBetween.prev;
            inBetween.prev.next = inBetween.next;
            inBetween.next.prev = aux;
        }

        @Override
        public void set(E e) {
            inBetween.data = e;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        print(list);
        list.add(9);
        print(list);
        list.add(20);
        print(list);
        list.add(22);
        print(list);
        list.add(25);
        print(list);
        list.add(15);
        print(list);
        list.add(30);
        print(list);
        list.add(3);
        print(list);
        list.add(7);
        print(list);
        list.add(30);
        print(list);
        list.add(35);
        print(list);
        list.add(78);
        list.add(78);
        list.add(66);

        print(list);
    }

    private static void print(LinkedList<Integer> list){
        ListIterator<Integer> itr = (ListIterator<Integer>) list.iterator();
        while (itr.hasNext()) {
            System.out.print( itr.next() + ", ");
        }
        System.out.println();

    }
}

