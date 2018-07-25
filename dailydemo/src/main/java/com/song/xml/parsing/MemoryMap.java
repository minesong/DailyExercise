package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "memoryMap")
public class MemoryMap {
    public MemoryMap() {
    	addressBlock = new ArrayList<>();
    }
    @Element(name = "name", required = false)
    private static String spiritName;
    
    @Element(name = "description", required = false)
    private String description;

    @ElementList(inline = true)
    private List<AddressBlock> addressBlock;

	public String getSpiritName() {
		return spiritName;
	}

	public void setSpiritName(String spiritName) {
		MemoryMap.spiritName = spiritName;
	}

	public List<AddressBlock> getAddressBlock() {
		return addressBlock;
	}

	public void setAddressBlock(List<AddressBlock> addressBlock) {
		this.addressBlock = addressBlock;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MemoryMap [spiritName=" + spiritName + ", description=" + description + ", addressBlock=" + addressBlock
				+ "]";
	}
	
	
    
    
    
}