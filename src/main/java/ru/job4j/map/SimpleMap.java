package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        MapEntry<K, V> kvMapEntry = new MapEntry<>(key, value);
        int index = indexFor(hash(key));
        if (table[index] == null) {
            table[index] = kvMapEntry;
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode() ^ key.hashCode() >>> 16;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> mapEntry : table) {
            if (mapEntry != null) {
                int index = indexFor(hash(mapEntry.key));
                newTable[index] = mapEntry;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V value = null;
        int index = indexFor(hash(key));
        if (table[index] != null
                && (hash(table[index].key) == hash(key)
                && Objects.equals(table[index].key, key))) {
                value = table[index].value;
            }
        return value;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = indexFor(hash(key));
        if (table[index] != null
                && hash(table[index].key) == hash(key)
                && Objects.equals(table[index].key, key)) {
            table[index] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            final int expectModCount = modCount;
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectModCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < table.length && table[cursor] == null) {
                    cursor++;
                }
                return cursor < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
