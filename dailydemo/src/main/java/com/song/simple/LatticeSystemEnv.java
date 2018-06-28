package com.song.simple;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "systemEnv")
public class LatticeSystemEnv {
    @Element(name = "modelParameter",required = false)
    private ModelParameter modelParameter;

    public ModelParameter getModelParameter() {
        return modelParameter;
    }

    public void setModelParameter(ModelParameter modelParameter) {
        this.modelParameter = modelParameter;
    }

    @Override
    public String toString() {
        return "LatticeSystemEnv{" +
                "modelParameter=" + modelParameter +
                '}';
    }
}
