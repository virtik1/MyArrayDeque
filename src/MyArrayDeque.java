import java.util.*;
import java.util.NoSuchElementException;

public class MyArrayDeque<T> {

    private Object[] array;
    private int size;
    private int capacity;

    public MyArrayDeque() {
      array = new Object[12];
      capacity = 12;
    }

    public MyArrayDeque(int initialCapacity) {
        array = new Object[initialCapacity];
        capacity = initialCapacity;
    }

    public void add(T o) {
        addFirst(o);
    }

    public void addFirst(T o) {
        if (isEmpty()) {
            array[0] = o;
            size ++;
        }
        else if (size < capacity){
            moveBack();
            array[0] = o;
            size ++;
        }
        else {
            resize();
            moveBack();
            array[0] = o;
            size ++;
        }
    }

    public void addLast(T o) {
        if (size < capacity) {
            array[size] = o;
            size ++;
        }
        else {
            resize();
            array[size] = o;
            size ++;
        }
    }

    public boolean offerFirst(T o) {
        if (size < capacity) {
            addFirst(o);
            return true;
        }
        return false;
    }

    public boolean offerLast(T o) {
        if (size < capacity) {
            addLast(o);
            return true;
        }
        return false;
    }

    private void moveBack() {
        for (int i = size; i > 0; i --) {
            array[i] = array[i - 1];
        }
    }

    private void moveForward(int first) {
        for(int i = first; i < size - 1; i ++) {
            array[i] = array[i + 1];
        }
    }

    private void resize() {
        Object[] tmp;
        capacity *= 2;
        tmp = new Object[capacity];

        for (int i = 0; i < size; i ++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    public Object removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Object tmp = array[0];
        moveForward(0);
        size --;
        return tmp;
    }

    public Object removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Object tmp = array[size - 1];
        size --;
        return tmp;
    }

    public Object pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Object tmp = array[0];
        moveForward(0);
        size --;
        return tmp;
    }

    public Object pollLast() {
        if (isEmpty()) {
            return null;
        }
        Object tmp = array[size - 1];
        size --;
        return tmp;
    }

    public Object getFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[0];
    }

    public Object getLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[size - 1];
    }

    public Object peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    public Object peekLast() {
        if (isEmpty()) {
            return  null;
        }
        return array[size - 1];
    }

    public boolean removeFirstOccurrence(T o) {
        for(int i = 0; i < size; i ++) {
            if (array[i].equals(o)) {
                moveForward(i);
                size --;
                return true;
            }
        }
        return false;
    }

    public boolean removeLastOccurrence(T o) {
        for (int i = size - 1; i >= 0 ; i --) {
            if (array[i].equals(o)) {
                moveForward(i);
                size --;
                return true;
            }
        }
        return false;
    }

    public boolean offer(T o) {
        return offerFirst(o);
    }

    public Object remove() {
        return removeFirst();
    }

    public Object poll() {
        return pollFirst();
    }

    public Object element() {
        return null;
    }

    public Object peek() {
        return peekFirst();
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public void clear() {

    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public void push(T o) {
        addFirst(o);
    }

    public Object pop() {
        return removeFirst();
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public boolean contains(T o) {
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public Iterator descendingIterator() {
        return null;
    }
}
