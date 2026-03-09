package net.biyi.bdccwissalbiyispringmvc.web;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import net.biyi.bdccwissalbiyispringmvc.entities.Product;
import net.biyi.bdccwissalbiyispringmvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/index")
    public String index(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "products";
    }

    @GetMapping("/")
    public String home(){

        return "redirect:/index";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam(name="id") Long id){
        productRepository.deleteById(id);
        return "redirect:/index";

    }
    @GetMapping("/newProduct")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "new-product";

    }
    @PostMapping("/saveProduct")
    public String saveProduct(@Valid Product product , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()) return "new-product";
        productRepository.save(product);
        return "redirect:/newProduct";


    }
}