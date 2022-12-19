package com.pyyh.inoutbound.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.inoutbound.business.initializer.TestTcpChannelinitializer;
import com.pyyh.inoutbound.business.initializer.TestUDPChannelinitializer;
import com.pyyh.inoutbound.pojo.CommunicationConfigPojo;
import com.pyyh.inoutbound.service.CommunicationChannelFactory;
import com.pyyh.inoutbound.serviceimp.TCPServerFactory;
import com.pyyh.inoutbound.serviceimp.UDPFactory;
import com.pyyh.inoutbound.util.ContainerUtil;

@Configuration
public class SourceConfig {

	@Bean
	public void initSource() throws Exception{
		String root = System.getProperty("user.dir");
		//通讯配置
		FileInputStream communication_fis = null;
		try{
			communication_fis = new FileInputStream(new File(root + "/business-config/communication-config.pyyh"));
			byte[] data_config = new byte[communication_fis.available()];
			communication_fis.read(data_config);
			CommunicationConfigPojo ccp = JSONObject.parseObject(data_config, CommunicationConfigPojo.class);
			ContainerUtil.setCommunicationConfigPojo(ccp);
		}finally{
			communication_fis.close();
		}
		//业务链
		List<String> lizers = ContainerUtil.getCommunicationConfigPojo().getLizers();
		ContainerUtil.getLizers().put(lizers.get(0), new TestTcpChannelinitializer());
		ContainerUtil.getLizers().put(lizers.get(1), new TestUDPChannelinitializer());
	}
	@Bean
	public void register(){
		CommunicationChannelFactory factory_tcp = new TCPServerFactory();
		factory_tcp.openChannel(ContainerUtil.getCommunicationConfigPojo());
		CommunicationChannelFactory factory_udp = new UDPFactory();
		factory_udp.openChannel(ContainerUtil.getCommunicationConfigPojo());
	}
}
