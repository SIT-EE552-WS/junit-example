package edu.stevens.friccobo;

import java.util.Collection;
import java.util.Iterator;

public class MyList<T> implements Collection<T> {
    Object[] contents = new Object[10];
    int currPos = 0;

    @Override
    public int size() {
        return currPos;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        contents[currPos] = t;
        currPos++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int pos;
        boolean found = false;
        for(pos = 0; pos < currPos; pos++){
            if(get(pos).equals(o)){
                found = true;
                break;
            }
        }
        if(found) {
            System.arraycopy(
                    contents,
                    pos + 1,
                    contents,
                    pos,
                    currPos - pos
            );
            currPos--;
        }
        return found;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        currPos = 0;
    }

    public T get(int index) {
        if(index < currPos) {
            //noinspection unchecked
            return (T) contents[index];
        } else {
            throw new IndexOutOfBoundsException(index + "is out of bounds for a list of size "+ currPos);
        }
    }
}
