package spring_pract.les3_rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_pract.les3_rest.models.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
