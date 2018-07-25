package com.song.xml.parsing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "addressBlock")
public class SpiritAddressBlock {
	
    @Element(name = "name", required = false)
    private String spiritName;
    
    @Element(name = "baseAddress", required = false)
    private String spiritBaseAddress;

    @Element(name = "range", required = false)
    private String spiritRange;

    @Element(name = "width", required = false)
    private String spiritWidth;
    
    @Element(name = "usage", required = false)
    private String spiritUsage;

    @Element(name = "access", required = false)
    private String spiritAccess;

	public String getSpiritName() {
		return spiritName;
	}

	public void setSpiritName(String spiritName) {
		this.spiritName = spiritName;
	}

	public String getSpiritBaseAddress() {
		return spiritBaseAddress;
	}

	public void setSpiritBaseAddress(String spiritBaseAddress) {
		this.spiritBaseAddress = spiritBaseAddress;
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

	public String getSpiritUsage() {
		return spiritUsage;
	}

	public void setSpiritUsage(String spiritUsage) {
		this.spiritUsage = spiritUsage;
	}

	public String getSpiritAccess() {
		return spiritAccess;
	}

	public void setSpiritAccess(String spiritAccess) {
		this.spiritAccess = spiritAccess;
	}

	@Override
	public String toString() {
		return "\nSpiritAddressBlock\n [spiritName=" + spiritName + ", spiritBaseAddress=" + spiritBaseAddress
				+ ", spiritRange=" + spiritRange + ", spiritWidth=" + spiritWidth + ", spiritUsage=" + spiritUsage
				+ ", spiritAccess=" + spiritAccess + "]\n";
	}
    
    

}
