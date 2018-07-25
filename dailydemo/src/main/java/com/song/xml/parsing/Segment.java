package com.song.xml.parsing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "segment")
public class Segment {

    @Element(name = "name", required = false)
    private String spiritName;
    
    @Element(name = "displayName", required = false)
    private String spiritDisplayName;

    @Element(name = "addressOffset", required = false)
    private String spiritAddressOffset;

    @Element(name = "range", required = false)
    private String spiritRange;

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

	public String getSpiritAddressOffset() {
		return spiritAddressOffset;
	}

	public void setSpiritAddressOffset(String spiritAddressOffset) {
		this.spiritAddressOffset = spiritAddressOffset;
	}

	public String getSpiritRange() {
		return spiritRange;
	}

	public void setSpiritRange(String spiritRange) {
		this.spiritRange = spiritRange;
	}

	@Override
	public String toString() {
		return "\nSegment\n [spiritName=" + spiritName + ", spiritDisplayName=" + spiritDisplayName
				+ ", spiritAddressOffset=" + spiritAddressOffset + ", spiritRange=" + spiritRange + "]\n";
	}
    
    
}
