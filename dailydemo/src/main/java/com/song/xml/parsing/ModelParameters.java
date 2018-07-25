package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root(name = "modelParameters")
public class ModelParameters {
    public ModelParameters() {
    	modelParameter = new ArrayList<>();
    }
    
    @ElementList(inline = true, required = false)
    private List<ModelParameter> modelParameter;

	public List<ModelParameter> getModelParameter() {
		return modelParameter;
	}

	public void setModelParameter(List<ModelParameter> modelParameter) {
		this.modelParameter = modelParameter;
	}

	@Override
	public String toString() {
		return "\n [modelParameter=" + modelParameter + "]";
	}
    
    
    
}