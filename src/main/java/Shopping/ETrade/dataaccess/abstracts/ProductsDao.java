package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDao extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);

    Product getByProductId(int productId);
    //void deleteAll();

    void deleteById(int productId);

}
