package com.vodqa.productservice;

import au.com.dius.pact.provider.junit.Consumer;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactUrl;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.vodqa.productservice.web.controllers.ProductController;
import com.vodqa.productservice.web.models.Product;
import com.vodqa.productservice.web.services.ProductService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import static org.mockito.Mockito.when;

@RunWith(PactRunner.class)
@Provider("product-service")
@Consumer("penguin")
@PactBroker(host = "localhost", port = "8888")
//@PactUrl(urls = {"http://localhost:8888/pacts/provider/product-service/consumer/penguin/latest"})
//@PactFolder(value = "./src/test/contract/provider/resources/pacts")
public class PenguinContractTest {
    @TestTarget
    public MockMvcTarget target = new MockMvcTarget();

    @Mock
    private ProductService productService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        ProductController productController = new ProductController(productService);
        target.setControllers(productController);
    }

    @State("HasProductDetails")
    public void shouldReturnProductDetails() {
        when(productService.getProductById(123)).thenReturn(new Product(123, "Pen", 890));
    }

}


//@RunWith(PactRunner.class)
//@Provider("product-service")
//@Consumer("penguin")
//@PactUrl(urls = {"http://localhost:8888/pacts/provider/product-service/consumer/penguin/latest"})
//public class PenguinContractTest {
//    @TestTarget
//    public final Target target = new HttpTarget("http", "localhost", 8080, "/");
//
//    private static ConfigurableWebApplicationContext application;
//
//    @BeforeClass
//    public static void start() {
//        application = (ConfigurableWebApplicationContext)
//                SpringApplication.run(ProductServiceApplication.class);
//    }
//
//    @State("HasProductDetails")
//    public void shouldReturnProductDetails(){
//    }
//}
