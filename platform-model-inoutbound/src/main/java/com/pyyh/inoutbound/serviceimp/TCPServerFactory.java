package com.pyyh.inoutbound.serviceimp;

import java.net.InetSocketAddress;

import com.pyyh.inoutbound.pojo.CommunicationConfigPojo;
import com.pyyh.inoutbound.pojo.TcpServerConfigPojo;
import com.pyyh.inoutbound.service.CommunicationChannelFactory;
import com.pyyh.inoutbound.util.ContainerUtil;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TCPServerFactory extends CommunicationChannelFactory {

	@Override
	public Object openChannel(Object p) {
		// TODO Auto-generated method stub
		TcpServerConfigPojo tcpCnf = ((CommunicationConfigPojo) p).getTcpServer();
		if (tcpCnf.isUsed()) {
			EventLoopGroup boss = new NioEventLoopGroup();
			EventLoopGroup work = new NioEventLoopGroup();
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(boss, work).channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, tcpCnf.getQueueSize())
					.childOption(ChannelOption.RCVBUF_ALLOCATOR, 
							new AdaptiveRecvByteBufAllocator(tcpCnf.getMiniBuf(), 
									tcpCnf.getInitBuf(), tcpCnf.getMaxBuf())).childHandler(
							ContainerUtil.getLizers().get(tcpCnf.getLizer())
			);
			for(String s : tcpCnf.getIpAddress()){
				String[] tmpAddress = s.split(":");
				ChannelFuture f = boot.bind(new InetSocketAddress(tmpAddress[0], Integer.parseInt(tmpAddress[1])));
			}
		}
		return "";
	}

}
