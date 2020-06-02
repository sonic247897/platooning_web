package com.gunzip.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="test")
public class mongoDTO {
	@Id
	String _id;
	
	String userid;
	String carnum;
	String sensorType;
	String sensorData;
	String saveDate;
	
	public mongoDTO() {
		super();
	}

	public mongoDTO(String userid, String carnum, String sensorType, String sensorData, String saveDate) {
		super();
		this.userid = userid;
		this.carnum = carnum;
		this.sensorType = sensorType;
		this.sensorData = sensorData;
		this.saveDate = saveDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getSensorData() {
		return sensorData;
	}

	public void setSensorData(String sensorData) {
		this.sensorData = sensorData;
	}

	public String getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}

	@Override
	public String toString() {
		return "mongoDTO [_id=" + _id + ", userid=" + userid + ", carnum=" + carnum + ", sensorType=" + sensorType
				+ ", sensorData=" + sensorData + ", saveDate=" + saveDate + "]";
	}
}