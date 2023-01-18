package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.entities.concretes.Category;
import Shopping.ETrade.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,Integer> {
    Category getByCategoryId(int categoryId);

    void deleteById(int categoryId);

    //void deleteAll();
}
