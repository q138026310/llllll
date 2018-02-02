package com.dlts.hrms.cm;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * dlts map
 * 
 * @author wuwen
 *
 */
public class Gap {

	private Map<String, Object> map;

	public static Gap newMap() {
		Gap p = new Gap();
		p.map = Maps.newHashMap();
		return p;
	}

	public static Gap newMap(String key, Object value) {
		Gap p = newMap();
		p.put(key, value);
		return p;
	}

	public Gap put(String key, Object value) {
		this.map.put(key, value);
		return this;
	}

	public Gap remove(String key) {
		this.map.remove(key);
		return this;
	}

	public int size() {
		return this.map.size();
	}

	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	public Gap clear() {
		this.map.clear();
		return this;
	}

}
