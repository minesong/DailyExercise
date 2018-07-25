package com.song.xml.parsing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "segments")
public class Segments {
    public Segments() {
    	segment = new ArrayList<>();
    }
    
    @ElementList(inline = true, required = false)
    private List<Segment> segment;

	public List<Segment> getSegment() {
		return segment;
	}

	public void setSegment(List<Segment> segment) {
		this.segment = segment;
	}

	@Override
	public String toString() {
		return "Segments [segment=" + segment + "]";
	}
    
    
    
}