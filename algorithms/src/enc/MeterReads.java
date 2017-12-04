package enc;

/*****************************************************************************
 *                                                                           *
 *                       Copyright (c) 2012-2013 London Hydro                *
 *                            ALL RIGHTS RESERVED                            *
 *                                                                           *
 *****************************************************************************
 *
 *  File Name:  MeterReads.java
 *
 *  Facility:   London Hydro Model
 *
 *  Author:     Love Talwar, Affinity Systems
 *
 *  Revision History
 *
 *  Date        Author              Description
 *  -------     ------------------  -----------------------------------------
 *  21Mar13     Love Talwar 		Original version
 */


import java.text.DateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * MeterReads entity.
 * 
 * @author Love Talwar (ltalwar@affsys.com)
 */

public class MeterReads {

	
	private String meterID;

	
	private String meterNumber;

	
	private Double readValue;

	
	private Date readDate;

	
	private String readType;

	public String getMeterID() {
		return meterID;
	}

	public void setMeterID(String meterID) {
		this.meterID = meterID;
	}

	public Double getReadValue() {
		return readValue;
	}

	public void setReadValue(Double readValue) {
		this.readValue = readValue;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	public String getReadType() {
		return readType;
	}

	public void setReadType(String readType) {
		this.readType = readType;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

}
