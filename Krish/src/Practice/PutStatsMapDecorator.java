package src.Practice;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

class PutStatsMapDecorator<K, V> implements Map<K, V> {
	private final Map<K, V> map; // map being decorated

	private int countPut;
	private int countPutAll;
	private int countPutIfAbsent;

	public PutStatsMapDecorator(Map<K, V> map) {
		this.map = map;
	}

	// stats getters
	public int getCountPut() {
		return countPut;
	}

	public int getCountPutAll() {
		return countPutAll;
	}

	public int getCountPutIfAbsent() {
		return countPutIfAbsent;
	}

	// override appropriate methods to update counters
	@Override
	public V put(K key, V value) {
		countPut++;
		return map.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		countPutAll++;
		map.putAll(m);
	}

	@Override
	public V putIfAbsent(K key, V value) {
		countPutIfAbsent++;
		return map.putIfAbsent(key, value);
	}

	// implement remaining methods of Map interface by delegating calls to `map`
	// field
	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return map.get(key);
	}

	@Override
	public V remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return map.entrySet();
	}
}