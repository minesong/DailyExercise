package com.song.xml.parsing;


import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



@Root(name = "systemEnv")
public class SystemEnv {
	
    public SystemEnv() {
    	latticeSystem = new ArrayList<>();
    }
    
    @ElementList(inline = true, required = false)
    private List<LatticeSystem> latticeSystem;



	public List<LatticeSystem> getLatticeSystem() {
		return latticeSystem;
	}



	public void setLatticeSystem(List<LatticeSystem> latticeSystem) {
		this.latticeSystem = latticeSystem;
	}



	@Override
	public String toString() {
		return "SystemEnv [latticeSystem=" + latticeSystem + "]";
	}


}
