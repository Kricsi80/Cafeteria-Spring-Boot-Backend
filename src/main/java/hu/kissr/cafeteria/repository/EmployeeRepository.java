package hu.kissr.cafeteria.repository;

import hu.kissr.cafeteria.helperClass.EmployeeDebt;
import hu.kissr.cafeteria.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

   @Query(value = "select \n" +
            "\temployee.name as employee_name, sum (purchase_has_product.purchase_price_total) \n" +
            "\t as debt from (\n" +
            "\tselect * from purchase\n" +
            "\twhere EXTRACT(MONTH from created_at) = :month_in\n" +
            "\t) as filtered_purchases\n" +
            "\tinner join employee\n" +
            "\ton employee.id = filtered_purchases.employee_id\n" +
            "\tinner join purchase_has_product\n" +
            "\ton filtered_purchases.id = purchase_has_product.purchase_id\n" +
            "\twhere employee.id = filtered_purchases.employee_id\n" +
            "    group by employee.name\n" +
            "    order by employee.name asc", nativeQuery = true)
    List<EmployeeDebt> getDebtOfAllEmployeesByMonth(@Param("month_in") Integer month_in);



}