package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root(name = "addressSpaces")
public class AddressSpaces {
    public AddressSpaces() {
    	addressSpace = new ArrayList<>();
    }
    
    @ElementList(inline = true, required = false)
    private List<AddressSpace> addressSpace;

	public List<AddressSpace> getAddressSpace() {
		return addressSpace;
	}

	public void setAddressSpace(List<AddressSpace> addressSpace) {
		this.addressSpace = addressSpace;
	}

	@Override
	public String toString() {
		return "AddressSpaces [addressSpace=" + addressSpace + "]";
	}
    
    

}
