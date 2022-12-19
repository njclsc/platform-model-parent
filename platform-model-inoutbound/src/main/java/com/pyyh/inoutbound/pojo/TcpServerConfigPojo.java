package com.pyyh.inoutbound.pojo;

import java.util.List;

public class TcpServerConfigPojo {
	private boolean used;
	private List<String> ipAddress;
	private int miniBuf;
	private int initBuf;
	private int maxBuf;
	private int queueSize;
	private String lizer;
	public String getLizer() {
		return lizer;
	}
	public void setLizer(String lizer) {
		this.lizer = lizer;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public List<String> getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(List<String> ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getQueueSize() {
		return queueSize;
	}
	public void setQueueSize(int queueSize) {
		this.queueSize = queueSize;
	}
	public int getMiniBuf() {
		return miniBuf;
	}
	public void setMiniBuf(int miniBuf) {
		this.miniBuf = miniBuf;
	}
	public int getInitBuf() {
		return initBuf;
	}
	public void setInitBuf(int initBuf) {
		this.initBuf = initBuf;
	}
	public int getMaxBuf() {
		return maxBuf;
	}
	public void setMaxBuf(int maxBuf) {
		this.maxBuf = maxBuf;
	}
}
