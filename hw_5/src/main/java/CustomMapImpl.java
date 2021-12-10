import java.util.*;

public class CustomMapImpl<K, V> implements CustomMap<K, V> {

    private List<Node<K, V>> nodes = new ArrayList<>();


    @Override
    public void put(K key, V value) {
        for (Node<K, V> node : nodes) {
            boolean condition = key.hashCode() == node.getKey().hashCode() && key.equals(node.getKey()); // условие для одинаковых ключей
            if (condition) {
                nodes.get(nodes.indexOf(node)).setValue(value);
            }
        }
        nodes.add(new Node<>(key, value));
    }



    @Override
    public Set<K> setKeys() {
        Set<K> allKeys = new HashSet<>();
        for(Node<K,V> node : nodes) {
            allKeys.add(node.getKey());
        }
        return allKeys;
    }

    @Override
    public List<V> listValues() {
        List<V> allValues = new ArrayList<>();
        for(Node<K,V> node : nodes) {
            allValues.add(node.getValue());
        }
        return allValues;
    }

    @Override
    public V get(K key) {
        for (Node<K, V> node : nodes) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    private static class Node<K,V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}