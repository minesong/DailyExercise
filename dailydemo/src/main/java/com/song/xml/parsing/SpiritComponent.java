package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "component")
public class SpiritComponent {
	
    public SpiritComponent() {
    	memoryMaps = new ArrayList<>();
    	modelParameters = new ArrayList<>();
    	addressSpaces = new ArrayList<>();
    }
    @Element(name = "vendor", required = false)
    private String spiritVendor;

    @Element(name = "library", required = false)
    private String spiritLibrary;
    
    @Element(name = "name", required = false)
    private String spiritName;

    @Element(name = "version", required = false)
    private String spiritVersion;
  
    @ElementList(inline = true, required = false)
    private List<MemoryMaps> memoryMaps;
 
    @ElementList(inline = true, required = false)
    private List<ModelParameters> modelParameters;
    
    @ElementList(inline = true, required = false)
    private List<AddressSpaces> addressSpaces;

	public String getSpiritVendor() {
		return spiritVendor;
	}

	public void setSpiritVendor(String spiritVendor) {
		this.spiritVendor = spiritVendor;
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

	public List<MemoryMaps> getMemoryMaps() {
		return memoryMaps;
	}

	public void setMemoryMaps(List<MemoryMaps> memoryMaps) {
		this.memoryMaps = memoryMaps;
	}

	public List<ModelParameters> getModelParameters() {
		return modelParameters;
	}

	public void setModelParameters(List<ModelParameters> modelParameters) {
		this.modelParameters = modelParameters;
	}

	public List<AddressSpaces> getAddressSpaces() {
		return addressSpaces;
	}

	public void setAddressSpaces(List<AddressSpaces> addressSpaces) {
		this.addressSpaces = addressSpaces;
	}


	@Override
	public String toString() {
		return "\nSpiritComponent [spiritVendor=" + spiritVendor + ", spiritLibrary=" + spiritLibrary + ", spiritName="
				+ spiritName + ", spiritVersion=" + spiritVersion + ", memoryMaps=" + memoryMaps + ", modelParameters="
				+ modelParameters + ", addressSpaces=" + addressSpaces + "]";
	}
	
    
    
}