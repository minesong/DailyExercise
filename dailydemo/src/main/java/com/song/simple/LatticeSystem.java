package com.song.simple;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "system", strict = false)
public class LatticeSystem {
    public LatticeSystem(String library) {

        this.library = library;
    }

    public LatticeSystem() {
    }

    @Attribute(name = "id", required = false)
    private String id;
    @Element(name = "library", required = false)
    private String library = new String();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Element
    private String version;
    @Element
    private String name;


    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
