package com.song.xml.parsing;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "general")
public class General {

    @Element(name = "vendor", required = false)
    private String vendor;

    @Element(name = "library", required = false)
    private String spiritLibrary;
    
    @Element(name = "name", required = false)
    private String spiritName;

    @Element(name = "version", required = false)
    private String spiritVersion;
    
    @Element(name = "bsplocation", required = false)
    private String spiritBsplocation;

    @Element(name = "deviceFamily", required = false)
    private String spiritDeviceFamily;



	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getSpiritLibrary() {
		return spiritLibrary;
	}

	public void setSpiritLibrary(String spiritLibrary) {
		this.spiritLibrary = spiritLibrary;
	}

	public String getSpiritName() {
		return spiritName;
	}

	public void setSpiritName(String spiritName) {
		this.spiritName = spiritName;
	}

	public String getSpiritVersion() {
		return spiritVersion;
	}

	public void setSpiritVersion(String spiritVersion) {
		this.spiritVersion = spiritVersion;
	}

	public String getSpiritBsplocation() {
		return spiritBsplocation;
	}

	public void setSpiritBsplocation(String spiritBsplocation) {
		this.spiritBsplocation = spiritBsplocation;
	}

	public String getSpiritDeviceFamily() {
		return spiritDeviceFamily;
	}

	public void setSpiritDeviceFamily(String spiritDeviceFamily) {
		this.spiritDeviceFamily = spiritDeviceFamily;
	}

	@Override
	public String toString() {
		return "vendor=" + vendor + ", spiritLibrary=" + spiritLibrary + ", spiritName=" + spiritName
				+ ", spiritVersion=" + spiritVersion + ", spiritBsplocation=" + spiritBsplocation
				+ ", spiritDeviceFamily=" + spiritDeviceFamily;
	}
    
	
    
    
}