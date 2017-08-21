package com.labs.microservice.service.product;

import com.labs.microservice.service.product.domain.ProductDomain;
import com.labs.microservice.service.product.svc.ProductSvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceApplicationTests {
	@Autowired
	ProductSvc productSvc;

	@Test
	public void contextLoads() {
		ProductDomain p = new ProductDomain();
		p.setSku("12345");

		ProductDomain product = productSvc.findOne(p);
		System.out.println(product.toString());
	}

}
