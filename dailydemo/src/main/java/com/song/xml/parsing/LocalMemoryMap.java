package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root(name = "localMemoryMap")
public class LocalMemoryMap {
    public LocalMemoryMap() {
    	spiritAddressBlock = new ArrayList<>();
    }
    @Element(name = "name", required = false)
    private String spiritName;

    @Element(name = "displayName", required = false)
    private String spiritDisplayName;
    
    @Element(name = "description", required = false)
    private String spiritDescription;
    
    @ElementList(inline = true, required = false)
    private List<SpiritAddressBlock> spiritAddressBlock;

	public String getSpiritName() {
		return spiritName;
	}

	public void setSpiritName(String spiritName) {
		this.spiritName = spiritName;
	}

	public String getSpiritDisplayName() {
		return spiritDisplayName;
	}

	public void setSpiritDisplayName(String spiritDisplayName) {
		this.spiritDisplayName = spiritDisplayName;
	}

	public String getSpiritDescription() {
		return spiritDescription;
	}

	public void setSpiritDescription(String spiritDescription) {
		this.spiritDescription = spiritDescription;
	}

	public List<SpiritAddressBlock> getSpiritAddressBlock() {
		return spiritAddressBlock;
	}

	public void setSpiritAddressBlock(List<SpiritAddressBlock> spiritAddressBlock) {
		this.spiritAddressBlock = spiritAddressBlock;
	}

	@Override
	public String toString() {
		return "LocalMemoryMap [spiritName=" + spiritName + ", spiritDisplayName=" + spiritDisplayName
				+ ", spiritDescription=" + spiritDescription + ", spiritAddressBlock=" + spiritAddressBlock + "]";
	}
    
    
    
}