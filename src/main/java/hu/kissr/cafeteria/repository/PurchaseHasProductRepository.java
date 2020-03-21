package hu.kissr.cafeteria.repository;

import hu.kissr.cafeteria.model.PurchaseHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHasProductRepository extends JpaRepository<PurchaseHasProduct, Long> {


    PurchaseHasProduct save(PurchaseHasProduct purchaseHasProduct);
}
