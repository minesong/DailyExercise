package com.song.simple;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "modelParameter")
public class ModelParameter {

    @Element(name = "name", required = false)
    private String spiritName;

    @Element(name = "displayName", required = false)
    private String spiritDisplayName;

    @Element(name = "description", required = false)
    private String spiritDescription;

    @Element(name = "value", required = false)
    private SpiritValue spiritValue;

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

    public SpiritValue getSpiritValue() {
        return spiritValue;
    }

    public void setSpiritValue(SpiritValue spiritValue) {
        this.spiritValue = spiritValue;
    }

    @Override
    public String toString() {
        return "ModelParameter{" +
                "spiritName='" + spiritName + '\'' +
                ", spiritDisplayName='" + spiritDisplayName + '\'' +
                ", spiritDescription='" + spiritDescription + '\'' +
                ", spiritValue=" + spiritValue +
                '}';
    }
}
