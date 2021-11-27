package ua.com.alevel;

public class CustomerList<E> implements DynamicArray<E> {
    private int initialCapacity;
    private Object[] array;

    public CustomerList() {            //создам дефолтный конструктор для нашего листа
        this.initialCapacity = 16;
        this.array = new Object[initialCapacity];
    }

    public int size() {             //метод вычисления размера списка

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void add(Object o) {      //добавление новых элементов в список
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = o;
                break;
            }
        }
    }

    @Override
    public Object get(int i) {
        return array[i];
    }   //достать элемент по индексу

    @Override
    public void set(int i, Object o) {      //апдейт элемента по индексу
        array[i] = o;
    }

    @Override
    public void delete(int i) {         //удаление элемента по индексу
        if (i < size()) {
            array[i] = null;
            createNewArray(array);
        }

    }

    private void createNewArray(Object[] array) {       //создание нового массива после удаление элемента
        Object[] newArray = new Object[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                newArray[j] = array[i];
                j++;
            }
            if ((i + 1) < initialCapacity && array[i] == null && array[i + 1] == null) {
                break;
            }

        }
        this.array = newArray;
    }

}