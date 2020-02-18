package spring_pract.les3_rest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_pract.les3_rest.dao.CategoryDao;
import spring_pract.les3_rest.dao.ProductDao;
import spring_pract.les3_rest.models.Category;
import spring_pract.les3_rest.models.Product;
import spring_pract.les3_rest.services.EmailService;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductDao productDao;



  /*  @GetMapping("/categories")
    public List<Category> categoryList(){
        return categoryDao.findAll();
    }

    @PostMapping("/category/{name}/{product}")
    public void saveCategory(@PathVariable String name,@PathVariable String product){

        String[] s = product.split("_");
        List<Product>productList = Stream.of(s).map(s1 -> Product.builder().name(s1).build()).collect(Collectors.toList());
        Category category = new Category(name);
        categoryDao.save(category);

        productList.stream().forEach(productEach -> {
            productEach.setCategory(category);
            productDao.save(productEach);
        });
    }
@PostMapping("/category")
    public List<Category> saveCategory(@RequestBody Category category){
   categoryDao.save(category);
   category.getProduct().forEach(product -> {product.setCategory(category);
   productDao.save(product);
   });
        return categoryDao.findAll();
}
*/
  /*  @PostMapping("/categories")
    public List<Category>saveCategory(@RequestBody Category category){
        categoryDao.save(category);
        return categoryDao.findAll();
    }

   / @PostMapping("/products")
    public List<Product>saveProduct(@RequestBody Product product){
        productDao.save(product);
        return  productDao.findAll();
    }*/
  @Autowired
private EmailService emailService;
    @PostMapping ("/join")
    public  List<Category> showAll(@RequestBody Category category) {
        categoryDao.save(category);
        category.getProduct().forEach(product -> {
            product.setCategory(category);
            productDao.save(product);

        });
        emailService.send(category);
        return categoryDao.findAll();
    }
    
};











