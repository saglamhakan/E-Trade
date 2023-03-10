package Shopping.ETrade.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDto {

    private String productName;

    private int productPrice;

    private int unitInStock;

    private String productColor;

    private String categoryName;

}
