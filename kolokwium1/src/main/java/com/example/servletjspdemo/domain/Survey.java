package com.example.servletjspdemo.domain;

public class Survey {
	
    private String dateFrom;
    private String dateTo;
    private String frequency;
    private String comment;
    
    public Survey() {
    	super();
    }
    
    public Survey(String dateFrom, String dateTo, String frequency, String comment) {
    	this.dateFrom = dateFrom;
    	this.dateTo = dateTo;
    	this.frequency = frequency;
    	this.comment = comment;
    }

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    

}
