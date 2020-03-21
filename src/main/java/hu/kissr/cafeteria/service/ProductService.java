package hu.kissr.cafeteria.service;

import hu.kissr.cafeteria.helperClass.ProductSold;
import hu.kissr.cafeteria.model.Product;
import hu.kissr.cafeteria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<ProductSold> getProductSold(Integer month) {
        return productRepository.getProductAmountSoldByMonth(month);
    }
}
