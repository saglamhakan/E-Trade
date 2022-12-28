package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDao extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);

    Product getByProductId(int productId);
}
