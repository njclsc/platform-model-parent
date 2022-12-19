package com.pyyh.inoutbound.serviceimp;

import java.net.InetSocketAddress;

import com.pyyh.inoutbound.business.initializer.TestUDPChannelinitializer;
import com.pyyh.inoutbound.pojo.CommunicationConfigPojo;
import com.pyyh.inoutbound.pojo.UDPConfigPojo;
import com.pyyh.inoutbound.service.CommunicationChannelFactory;
import com.pyyh.inoutbound.util.ContainerUtil;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UDPFactory extends CommunicationChannelFactory{

	@Override
	public Object openChannel(Object p) {
		// TODO Auto-generated method stub
		UDPConfigPojo udpCnf = ((CommunicationConfigPojo) p).getUdp();
		if(udpCnf.isUsed()){
			EventLoopGroup work = new NioEventLoopGroup();
			Bootstrap boot = new Bootstrap();
			boot.group(work).channel(NioDatagramChannel.class).option(ChannelOption.RCVBUF_ALLOCATOR, 
					new AdaptiveRecvByteBufAllocator(udpCnf.getMiniBuf(),
						udpCnf.getInitBuf(), udpCnf.getMaxBuf())).handler(
							ContainerUtil.getLizers().get(udpCnf.getLizer())
					);
			for(String s : udpCnf.getIpAddress()){
				String[] tmpAddress = s.split(":");
				ChannelFuture f = boot.bind(new InetSocketAddress(tmpAddress[0], Integer.parseInt(tmpAddress[1])));
			}
		}
		return null;
	}

}
