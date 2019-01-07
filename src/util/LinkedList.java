package util;

import java.util.*;

public class LinkedList<E> extends AbstractList<E> implements Iterable<E>
{
    private Node<E> head;
    private Node<E> tail;
    private int nodesNR;

    public LinkedList() {
    }

    /** constructor that creates list based on given objects
     can be empty*/
    public LinkedList(E... elements) {
        add(elements);
    }

    public LinkedList(LinkedList<E> original) {
        nodesNR = original.size();
        head = original.getHead();
        tail = original.getTail();
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

    /** adds elements at the end of the list
     even if the list is empty*/
    public boolean add(E... elements)
    {
        if (elements.length == 0) return false;

        int i = 0;

        /*in case list is empty initialize it*/
        if (head == null)
        {
            head = new Node<E>(elements[0]);
            tail = head;
            nodesNR = 1;
            i++;
        }

        for ( ; i < elements.length; i++)
        {
            Node<E> aux = tail;
            tail.next = new Node<>(elements[i]);
            tail = tail.next;
            tail.prev = aux;
            nodesNR++;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends E> c){
        add(c.toArray((E[]) new Object[c.size()]));
        return true;
    }

    public void addHead(E e){
        Node<E> newHead = new Node<>(e);
        newHead.next = head;
        if ( head != null)
            head.prev = newHead;
        head = newHead;
        if (tail == null) tail = head;

    }

    /**adds elements starting from index
     if index > number of nodes in the list, this method does nothing
     also cant add into an empty list*/
    public void addAtIndex(int index, E... elements)
    {
        if (elements.length == 0) return;
        if (index >= nodesNR) return; //this applies also when the list is empty

        Node current = goAtIndex(index);

        /*save the next el to re-link later*/
        Node temp = current.next;

        /*insert the new objects*/
        for ( int i = 0; i < elements.length; i++)
        {
            current.next = new Node<E>(elements[i]);
            current = current.next;
            nodesNR++;
        }

        /*re-link*/
        current.next = temp;
    }

    public E get(int index){
        return goAtIndex(index).data;
    }

    public Node<E> getNode(int index){
        return goAtIndex(index);
    }

    public int indexOf(Object e){
        e = (E) e;
        Node current  = getHead();
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
    }

    public E remove(int index){
        Node<E> current = goAtIndex(index);
        if ( current == null) return null;
        if ( current.next != null)
            current.next.prev = current.prev;
        if ( current.prev != null)
            current.prev.next = current.next;
        return current.data;
    }

    public boolean remove(Object e){
        return remove(indexOf(e)) != null;
    }

    public boolean isEmpty(){
        return nodesNR == 0;
    }

    public boolean removeAll(Collection<?> c){
        for(Object e: c) remove(e);
        return true;
    }

    public LinkedList<E> cloneList() {
        return new LinkedList<>(this);
    }

    public int size() {
        return nodesNR;
    }

    protected Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public String toString()
    {
        return nodesNR + " nodes in list:\n\n" + head;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIteratorImpl(getHead());
    }

    public ListIterator<E> listIterator(){
        return new ListIteratorImpl(getHead());
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
            return data + "  --> " + next;
        }
    }

    private class ListIteratorImpl implements ListIterator<E> {

        private Node<E> inBetween;
        private int index;

        ListIteratorImpl(Node<E> head){
            inBetween = new Node<>(null);
            head.prev = inBetween;
            inBetween.next = head;
            index = -1;
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
        list.addHead(6);
        list.add(10);
        list.add(20);
        list.addHead(5);
        list.add(22);
        list.add(25);
        list.add(30);
        list.add(30);
        list.add(30);
        list.add(30);
        list.add(30);
        list.add(35);
        list.addHead(3);
        System.out.println(list.getHead());

        int last = 0;
        System.out.println("Afisare 1");
        for (Integer i : list) {
            System.out.print(i + ", ");
            if (i < last) {
                System.err.println("LinkedList a fost implementata gresit.");
            }
            last = i;
        }
        System.out.println();

        System.out.println("Afisare 2");
        ListIterator<Integer> itr = (ListIterator<Integer>) list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.nextIndex() + ": " + itr.next() + ", ");
        }

        System.out.println();
        System.out.println("Afisare 3");
        while (itr.hasPrevious()) {
            System.out.print(itr.previousIndex() + ": " + itr.previous() + ", ");
        }

        System.out.println();
        System.out.println("Afisare 4");
        while (itr.hasNext()) {
            System.out.print(itr.nextIndex() + ": " + itr.next() + ", ");
        }
        System.out.println();

        list.remove(Integer.valueOf(30));
        System.out.println(list);
    }
}

