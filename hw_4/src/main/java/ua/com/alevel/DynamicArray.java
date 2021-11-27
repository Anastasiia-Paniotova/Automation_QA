package ua.com.alevel;

public interface DynamicArray<E> {

    void add(Object o);

    Object get(int i);

    void set(int i, Object o);

    void delete(int i);

}
