package com.anfegagra.gateway.feign;

import java.io.InputStream;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.commons.io.IOUtils;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.core.io.ClassPathResource;

public class SSLUtil {

	private static final String KEY_STORE_TYPE_JKS = "jks";

	public static SSLContext createSslContext(String jksPath, String jksPass) {

		InputStream inputStream = null;

		try {
			KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE_JKS);
			ClassPathResource classPathResource = new ClassPathResource(jksPath);
			inputStream = classPathResource.getInputStream();
			keyStore.load(inputStream, jksPass.toCharArray());

			return new SSLContextBuilder()
				.loadTrustMaterial(null, new TrustSelfSignedStrategy())
				.loadKeyMaterial(keyStore, jksPass.toCharArray()).build();

		} catch (Exception exception) {
			System.out.println("Exception occurred while creating ssl context ");

		} finally {
			IOUtils.closeQuietly(inputStream);
		}

		return null;
	}
}
