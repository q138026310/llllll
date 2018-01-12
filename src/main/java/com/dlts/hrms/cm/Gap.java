package com.dlts.hrms.cm;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;

/**
 * dlts map
 * 
 * @author wuwen
 *
 */
public class Gap {
	
	public Map<String,Object> map;
	
	public static Gap newMap(){
		Gap p = new Gap();
		p.map = Maps.newHashMap();
		return p;
	}
	
	public static Gap newMap(String key,Object value){
		Gap p = newMap();
		p.put(key, value);
		return p;
	}
	
	public Gap put(String key,Object value){
		this.map.put(key, value);
		return this;
	}
	
	public Gap remove(String key){
		this.map.remove(key);
		return this;
	}

	public int size() {
		return this.map.size();
	}

	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	public boolean containsKey(String key) {
		return this.map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return this.map.containsKey(value);
	}
	
	public Object get(String key) {
		return this.map.get(key);
	}

	public Gap putAll(Map<String,Object> m) {
		this.map.putAll(m);
		return this;
	}

	public Gap clear() {
		this.map.clear();
		return this;
	}

	public Set<String> keySet() {
		return this.map.keySet();
	}
	
	public Collection<Object> values() {
		return this.map.values();
	}
	
	public Set<Entry<String,Object>> entrySet() {
		return this.map.entrySet();
	} 

}
