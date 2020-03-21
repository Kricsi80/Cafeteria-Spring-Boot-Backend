package hu.kissr.cafeteria.repository;

import hu.kissr.cafeteria.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {


    @Query(value = "insert into public.purchase(employee_id)\n" +
            "\tvalues ( :employee_id_in)\n" +
            "\treturning purchase.id", nativeQuery = true)
    Integer createPurchase(@Param("employee_id_in") Long employeeIdIn);
}
