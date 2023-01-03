package Shopping.ETrade.Controllers;

import Shopping.ETrade.business.abstracts.ProductService;
import Shopping.ETrade.business.dtos.ProductListDto;
import Shopping.ETrade.business.request.AddProductRequest;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;
import Shopping.ETrade.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public DataResult<List<ProductListDto>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody AddProductRequest addProductRequest) {
        return (this.productService.add(addProductRequest));

    }


    public DataResult<Product> getByProductId(int productId) {
        return this.productService.getByCategoryId(productId);
    }

   /* @DeleteMapping("/delete")
    public ResponseEntity deleteProduct() {
        productService.delete();
        return ResponseEntity.ok().build();
   */ }
    //}
