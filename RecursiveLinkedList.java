/*
 * Title: RecursiveLinkedList.java
 * Abstract: Implements a linked list using recursion methods
 * Author: Justin Andreoli
 * Email: jandreoli@csumb.edu
 * Estimate: 3 hours
 * Date: 11/20/2024
 */

public class  RecursiveLinkedList <T extends Comparable<T>> {

    private Node first;

    public RecursiveLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        if(!isEmpty()) {
            return first.toString();
        }else{
            return "List is empty";
        }
    }

    public void prepend(T value) {
        Node n = new Node(value);
        n.next = first;
        first = n;
    }

    public RecursiveLinkedList<T> append(T value) {
        if(isEmpty()) {
            first = new Node(value);
        }else{
            first.append(value);
        }
        return this;
    }

    public boolean search(T value) {
        if(isEmpty()) {
            return false;
        }else{
            Node current = first;
            return current.search(value);
        }
    }

    public boolean remove(T value) {
        if(isEmpty()) {
            return false;
        }else{
            Node current = first;
            return current.removeNext(value);
        }

    }

    public RecursiveLinkedList<T> getDistinct() {
        RecursiveLinkedList<T> list = new RecursiveLinkedList<>();
        if(isEmpty()) {
            return list;
        } else {
            first.addIfNotPresent(list);
        }
        return list;
    }

    public boolean isSorted() {
        if(isEmpty()) {
            return true;
        }else{
            return first.isSortedAscending() || first.isSortedDescending();
        }
    }

    public void insertOrderedAscending(T value) {
        if(isEmpty()) {
            first = new Node(value);
        }else{
            if(first.data.compareTo(value) > 0){
                prepend(value);
            }else {
                first.insertOrderedAscending(value);
            }
        }

    }


    public void rotate() {
        if(isEmpty()) {
            return;
        }else{
            Node temp = first.next;
            first.moveToEnd(first);
            first = temp;
        }
    }

    public void reverse() {
        if(isEmpty()) {
            return;
        }else{
            Node temp = first;
            first = first.reverse(first);
            temp.next = null;
        }
    }

    class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }

        public boolean hasNext() {
            return next != null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if(hasNext()) {
                sb.append(data+" ");
                sb.append(getNext().toString());
            }else{
                return data+"";
            }
            return sb.toString();
        }

        public void append(T value) {
            Node current;
            if(hasNext()){
                current = getNext();
                current.append(value);
            }else{
                setNext(new Node(value));
            }
        }

        public boolean search(T value) {
            if(data.equals(value)) {
                return true;
            }else{
                if(hasNext()) {
                    return next.search(value);
                }
            }
            return false;
        }

        public boolean removeNext(T value) {
            if(hasNext()&& next.equals(value)) {
                next = next.next;
                return true;
            }else{
                if(hasNext()) {
                    return next.removeNext(value);
                }else{
                    return false;
                }
            }
        }

        public void addIfNotPresent(RecursiveLinkedList<T> list) {
            if(list.search(data)) {
                if(hasNext()) {
                    next.addIfNotPresent(list);
                }
            }else{
                list.append(data);
                if(hasNext()) {
                    next.addIfNotPresent(list);
                }
            }
        }

        public boolean isSortedAscending() {
            if(next == null) {
                return true;
            }else if (next.data.compareTo(data)<0){
                return false;
            }
            return next.isSortedAscending();
        }

        public boolean isSortedDescending() {
            if(next == null) {
                return true;
            }else if(next.data.compareTo(data)>0){
                return false;
            }
            return next.isSortedDescending();
        }

        public void insertOrderedAscending(T value) {
            if(next == null || next.data.compareTo(value) > 0) {
                Node n = new Node(value);
                n.next = next;
                next = n;
            }else{
                next.insertOrderedAscending(value);
            }
        }

        public void isSortedDescending(T value){
            if(next == null) {
                setNext(new Node(value));
            }else if(data.compareTo(value)>=0 && next.data.compareTo(value)<0){
                Node n = new Node(value);
                n.next = next;
                next = n;
            }else{
                next.isSortedDescending();
            }
        }

        public void moveToEnd(Node n) {
            if(hasNext()) {
                next.moveToEnd(n);
            }else{
                next = n;
                n.next = null;
            }
        }

        public Node reverse(Node n) {
            if(!hasNext()) {
                return this;
            }else{
                Node temp = next.reverse(n);
                next.next = this;
                return temp;
            }

        }


        public boolean equals(T value) {
            return this.data.equals(value);
        }

        public boolean equals(Node n) {
            return this.getData().equals(n.getData());
        }

    }
}
