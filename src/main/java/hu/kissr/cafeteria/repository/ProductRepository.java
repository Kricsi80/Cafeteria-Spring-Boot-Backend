package hu.kissr.cafeteria.repository;

import hu.kissr.cafeteria.helperClass.ProductSold;
import hu.kissr.cafeteria.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    @Query(value = "select \n" +
            "\tproduct.name as product_name, sum (purchase_has_product.amount) \n" +
            "\tas sold from (\n" +
            "\tselect * from purchase\n" +
            "\twhere EXTRACT(MONTH from created_at) = :month_in\n" +
            "\t) as filtered_purchases\n" +
            "\tinner join purchase_has_product\n" +
            "    on purchase_has_product.purchase_id = filtered_purchases.id\n" +
            "\tinner join product\n" +
            "\ton purchase_has_product.product_id  = product.id\n" +
            "\tgroup by product.name\n" +
            "    order by sold asc", nativeQuery = true)
    List<ProductSold> getProductAmountSoldByMonth(@Param("month_in") Integer month_in);
}
