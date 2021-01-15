package com.anfegagra.gateway.feign;

import feign.Client;
import javax.net.ssl.SSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSLFeignConfiguration {

	@Value("${server.ssl.key-store}")
	private String clientKeyStorePath;

	@Value("${server.ssl.key-store-password}")
	private String clientKeyStorePass;

	@Bean
	public Client getFeignClient() {
		SSLContext context = SSLUtil.createSslContext(clientKeyStorePath, clientKeyStorePass);
		return new Client.Default(context != null ? context.getSocketFactory() : null, null);
	}
}
