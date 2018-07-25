package com.song.xml.parsing;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "value")
public class SpiritValue {


    @Text
    private String spiritValue;

    @Attribute(name = "format", required = false)
    private String spiritFormat;

    @Attribute(name = "id", required = false)
    private String spiritId;

    @Attribute(name = "resolve", required = false)
    private String spiritResolve;

    public String getSpiritFormat() {
        return spiritFormat;
    }

    public void setSpiritFormat(String spiritFormat) {
        this.spiritFormat = spiritFormat;
    }

    public String getSpiritValue() {
		return spiritValue;
	}

	public void setSpiritValue(String spiritValue) {
		this.spiritValue = spiritValue;
	}

	public String getSpiritId() {
        return spiritId;
    }

    public void setSpiritId(String spiritId) {
        this.spiritId = spiritId;
    }

    public String getSpiritResolve() {
        return spiritResolve;
    }

    public void setSpiritResolve(String spiritResolve) {
        this.spiritResolve = spiritResolve;
    }
	@Override
	public String toString() {
		return "spiritValue=" + spiritValue + ", spiritFormat=" + spiritFormat + ", spiritId=" + spiritId
				+ ", spiritResolve=" + spiritResolve;
	}
    
    

}
