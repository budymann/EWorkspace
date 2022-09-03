package com.budymann.ProductService;

import com.budymann.ProductService.resource.CartResource;
import com.budymann.ProductService.resource.SessionResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	CartResource cartResource;

	@Autowired
	SessionResource sessionResource;

	@Test
	void contextLoads() {
		var publicToken = sessionResource.getPublicSessionToken();

		var a = publicToken;
	}

}
