package com.netent.bookstore.restservice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netent.bookstore.model.Coverage;

public class RestClientServiceTest {

	@InjectMocks
	private RestClientService<Coverage[]> restClientService;

	private RestTemplate restTemplate;

	private static final String COVERAGE_API_URL = "https://jsonplaceholder.typicode.com/posts";

	@Before
	public void init() {
		restTemplate = Mockito.mock(RestTemplate.class);
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSearchBookByISBN_should_return_list_of_empty_books() {

		ResponseEntity<Coverage[]> response = new ResponseEntity<>(
				new Coverage[] { new Coverage(1, 1, "abc", "abc xyz"), new Coverage(1, 1, "123", "abc great") },
				HttpStatus.OK);

		Mockito.when(restTemplate.getForEntity(ArgumentMatchers.anyString(), ArgumentMatchers.any(Class.class)))
				.thenReturn(response);

		Coverage[] cov = restClientService.callExternalApi(COVERAGE_API_URL, Coverage[].class);
		assertEquals(2, cov.length);
	}
}