package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



@Root(name = "addressSpace")
public class AddressSpace {
    public AddressSpace() {
    	segments = new ArrayList<>();
    	localMemoryMap = new ArrayList<>();
    }
    @Element(name = "name", required = false)
    private String spiritName;

    @Element(name = "range", required = false)
    private String spiritRange;
    
    @Element(name = "width", required = false)
    private String spiritWidth;
    
    @ElementList(inline = true, required = false)
    private List<Segments> segments;
    
    @ElementList(inline = true, required = false)
    private List<LocalMemoryMap> localMemoryMap;

	public String getSpiritName() {
		return spiritName;
	}

	public void setSpiritName(String spiritName) {
		this.spiritName = spiritName;
	}

	public String getSpiritRange() {
		return spiritRange;
	}

	public void setSpiritRange(String spiritRange) {
		this.spiritRange = spiritRange;
	}

	public String getSpiritWidth() {
		return spiritWidth;
	}

	public void setSpiritWidth(String spiritWidth) {
		this.spiritWidth = spiritWidth;
	}

	public List<Segments> getSegments() {
		return segments;
	}

	public void setSegments(List<Segments> segments) {
		this.segments = segments;
	}

	public List<LocalMemoryMap> getLocalMemoryMap() {
		return localMemoryMap;
	}

	public void setLocalMemoryMap(List<LocalMemoryMap> localMemoryMap) {
		this.localMemoryMap = localMemoryMap;
	}

	@Override
	public String toString() {
		return "AddressSpace [spiritName=" + spiritName + ", spiritRange=" + spiritRange + ", spiritWidth="
				+ spiritWidth + ", segments=" + segments + ", localMemoryMap=" + localMemoryMap + "]";
	}
    
	
    
    
}