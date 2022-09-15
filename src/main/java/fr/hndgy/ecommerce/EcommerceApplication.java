package fr.hndgy.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.hndgy.ecommerce.model.Product;
import fr.hndgy.ecommerce.repository.ProductRepository;
import fr.hndgy.ecommerce.service.product.ProductService;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner onStart(ProductService productService){
		return args -> {
			var p1 = new Product();
			p1.setName("Macbook pro M1");
			p1.setPrice(2000.);
			p1.setPictureUrl("https://www.apple.com/v/macbook-pro-14-and-16/a/images/meta/macbook-pro-14-and-16_overview__fz0lron5xyuu_og.png");
			productService.save(p1);

			var p2 = new Product();
			p2.setName("iPhone 14 Pro");
			p2.setPrice(1400.);
			p2.setPictureUrl("https://www.apple.com/v/iphone-14-pro/a/images/overview/camera/true-depth/true_depth_autofocus__cn4j7tuvc83m_large_2x.jpg");
			productService.save(p2);

			var p3 = new Product();
			p3.setName("Airpods Pro");
			p3.setPrice(300.);
			p3.setPictureUrl("https://www.apple.com/v/airpods-pro/g/images/overview/airpod_tips__dc5pbb4h970i_large_2x.jpg");
			productService.save(p3);

			var p4 = new Product();
			p4.setName("iPad Pro M1");
			p4.setPrice(1000.);
			p4.setPictureUrl("https://www.apple.com/v/ipad-pro/ai/images/overview/experience/intro_display_static__d19ubvnynzma_large_2x.jpg");
			productService.save(p4);

		};

	}

}
