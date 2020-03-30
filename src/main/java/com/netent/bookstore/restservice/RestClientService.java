package com.netent.bookstore.restservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author ajaychauhan01
 *
 * @param <T>
 * This a common class to call a third party rest endpoint.
 */
@Service
public class RestClientService<T> {

	private static final Logger LOGGER = LogManager.getLogger(RestClientService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${coverage.api.retry}")
	private int coverageApiRetry;

	public T callExternalApi(final String url, Class<T> clazz) {
		LOGGER.info("RestClientService:callExternalApi");
		ResponseEntity<T> response = null;

		int i = 1;
		//Retry in case of exception.
		while (response == null) {
			try {
				response = restTemplate.getForEntity(url, clazz);
			} catch (Exception e) {
				if (i++ > coverageApiRetry) {
					LOGGER.error("Exception in calling coverage API: ", e);
					throw e;
				}

				LOGGER.info("Retrying coverage API with count {}", i - 1);
			}
		}

		LOGGER.info("Resposne from {} is {}", url, response.getBody());
		return response.getBody();
	}
}
