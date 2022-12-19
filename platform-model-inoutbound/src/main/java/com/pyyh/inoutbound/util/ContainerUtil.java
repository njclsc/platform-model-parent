package com.pyyh.inoutbound.util;

import java.util.HashMap;

import com.pyyh.inoutbound.pojo.CommunicationConfigPojo;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;

public class ContainerUtil {

	private static CommunicationConfigPojo communicationConfigPojo;
	private static HashMap<String, ChannelInboundHandlerAdapter> lizers = new HashMap<>();
	public static CommunicationConfigPojo getCommunicationConfigPojo() {
		return communicationConfigPojo;
	}

	public static void setCommunicationConfigPojo(CommunicationConfigPojo communicationConfigPojo) {
		ContainerUtil.communicationConfigPojo = communicationConfigPojo;
	}

	public static HashMap<String, ChannelInboundHandlerAdapter> getLizers() {
		return lizers;
	}

	public static void setLizers(HashMap<String, ChannelInboundHandlerAdapter> lizers) {
		ContainerUtil.lizers = lizers;
	}

	
	

	
	
}
