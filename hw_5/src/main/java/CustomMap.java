import java.util.List;
import java.util.Set;


public interface CustomMap<K, V> {

    void put(K key, V value);
    Set<K> setKeys();
    List<V> listValues();
    V get(K key);
}