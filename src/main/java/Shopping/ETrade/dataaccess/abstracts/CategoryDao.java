package Shopping.ETrade.dataaccess.abstracts;

import Shopping.ETrade.entities.concretes.Category;
import Shopping.ETrade.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    Category getByCategoryId(int categoryId);

    //void deleteAll();
}
