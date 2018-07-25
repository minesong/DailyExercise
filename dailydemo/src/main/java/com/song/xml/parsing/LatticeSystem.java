package com.song.xml.parsing;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root(name = "system")
public class LatticeSystem {
	
    public LatticeSystem() {
    	general = new ArrayList<>();
    	component = new ArrayList<>();
    }
   
    @ElementList(inline = true, required = false)
    private List<General> general;
    
    @ElementList(inline = true, required = false)
    private List<SpiritComponent> component;

	public List<General> getGeneral() {
		return general;
	}

	public void setGeneral(List<General> general) {
		this.general = general;
	}


	public List<SpiritComponent> getComponent() {
		return component;
	}

	public void setComponent(List<SpiritComponent> component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "LatticeSystem [\ngeneral=" + general + ", \ncomponent=" + component + "]";
	}

	
    
}
