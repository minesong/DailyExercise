package com.song.xml.parsing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "addressBlock")
public class AddressBlock {
	
    @Element(name = "name", required = false)
    private String spiritName;
    
    @Element(name = "displayName", required = false)
    private String displayName;
    
    @Element(name = "description", required = false)
    private String description;

    @Element(name = "baseAddress", required = false)
    private String spiritBaseAddress;
    
    @Element(name = "range", required = false)
    private String spiritRange;

    @Element(name = "width", required = false)
    private String spiritWidth;
    
    @Element(name = "usage", required = false)
    private String usage;
    
    @Element(name = "access", required = false)
    private String access;
    
    

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

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

	@Override
	public String toString() {
		return "\nAddressBlock\n [spiritName=" + spiritName + ", displayName=" + displayName + ", description="
				+ description + ", spiritBaseAddress=" + spiritBaseAddress + ", spiritRange=" + spiritRange
				+ ", spiritWidth=" + spiritWidth + ", usage=" + usage + ", access=" + access + "]\n";
	}
	
	
    
    

}
