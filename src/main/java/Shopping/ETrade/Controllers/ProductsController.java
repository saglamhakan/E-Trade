package Shopping.ETrade.Controllers;

import Shopping.ETrade.business.abstracts.ProductService;
import Shopping.ETrade.core.result.DataResult;
import Shopping.ETrade.core.result.Result;
import Shopping.ETrade.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);

    }

    public DataResult<Product> getByCategoryId(int categoryId) {
        return this.productService.getByCategoryId(categoryId);
    }
}
