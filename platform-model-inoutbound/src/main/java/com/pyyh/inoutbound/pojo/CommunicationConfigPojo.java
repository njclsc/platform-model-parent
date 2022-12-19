package com.pyyh.inoutbound.pojo;

import java.util.List;

public class CommunicationConfigPojo {

	private TcpServerConfigPojo tcpServer;
	private UDPConfigPojo udp;
	private List<String> lizers;
	public TcpServerConfigPojo getTcpServer() {
		return tcpServer;
	}

	public void setTcpServer(TcpServerConfigPojo tcpServer) {
		this.tcpServer = tcpServer;
	}

	public UDPConfigPojo getUdp() {
		return udp;
	}

	public List<String> getLizers() {
		return lizers;
	}

	public void setLizers(List<String> lizers) {
		this.lizers = lizers;
	}

	public void setUdp(UDPConfigPojo udp) {
		this.udp = udp;
	}
}
