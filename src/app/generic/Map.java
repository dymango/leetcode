package app.generic;

/**
 * @author dimmy
 */
public interface Map<K, V> {

    V get(K k);

    void put(K k, V v);
}
