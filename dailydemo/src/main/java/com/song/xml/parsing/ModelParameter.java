package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "modelParameter")
public class ModelParameter {
	
    public ModelParameter() {
    	value = new ArrayList<>();
    }
	
    @Element(name = "name", required = false)
    private String spiritName;

    @Element(name = "displayName", required = false)
    private String spiritDisplayName;
    
    @Element(name = "description", required = false)
    private String spiritDescription;
    

    
    @ElementList(name = "value",inline = true, required = false)
    private List<SpiritValue> value;

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



	public List<SpiritValue> getValue() {
		return value;
	}

	public void setValue(List<SpiritValue> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "\nModelParameter\n [spiritName=" + spiritName + ", spiritDisplayName=" + spiritDisplayName
				+ ", spiritDescription=" + spiritDescription + ", value=" + value + "]\n";
	}



}
