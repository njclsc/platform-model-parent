package com.pyyh.inoutbound.business.initializer;

import com.pyyh.inoutbound.business.handler.TestUDPHander;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.DatagramChannel;

public class TestUDPChannelinitializer extends ChannelInitializer<DatagramChannel>{

	@Override
	protected void initChannel(DatagramChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ch.pipeline().addLast(new TestUDPHander());
	}

}
