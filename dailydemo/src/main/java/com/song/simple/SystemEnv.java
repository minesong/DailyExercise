package com.song.simple;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "systemEnv")
public class SystemEnv {
    @ElementList(inline = true)
    private List<LatticeSystem> systemList;

    public List<LatticeSystem> getSystemList() {
        return systemList;
    }

    public void setSystemList(List<LatticeSystem> systemList) {
        this.systemList = systemList;
    }
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
