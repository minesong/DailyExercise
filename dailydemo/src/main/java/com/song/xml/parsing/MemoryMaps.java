package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "memoryMaps")
public class MemoryMaps {
    public MemoryMaps() {
    	memoryMap = new ArrayList<>();
    }
    
    @ElementList(inline = true, required = false)
    private List<MemoryMap> memoryMap;

	public List<MemoryMap> getMemoryMap() {
		return memoryMap;
	}

	public void setMemoryMap(List<MemoryMap> memoryMap) {
		this.memoryMap = memoryMap;
	}

	@Override
	public String toString() {
		return "\n [memoryMap=" + memoryMap + "]";
	}
	
	
    
    
    
}