package hu.kissr.cafeteria.contoller;

import hu.kissr.cafeteria.helperClass.ProductSold;
import hu.kissr.cafeteria.model.Product;
import hu.kissr.cafeteria.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findAll() throws URISyntaxException {
        List<Product> result = productService.findAll();
        return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/sold/{month}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductSold>> getProductSold(@PathVariable Integer month) throws URISyntaxException {
        List<ProductSold> result = productService.getProductSold(month);
        return new ResponseEntity<List<ProductSold>>(result, HttpStatus.OK);
    }
}
