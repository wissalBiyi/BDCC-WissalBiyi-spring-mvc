package net.biyi.bdccwissalbiyispringmvc.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import net.biyi.bdccwissalbiyispringmvc.entities.Product;
import net.biyi.bdccwissalbiyispringmvc.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // afficher les produits + pagination + recherche
    @GetMapping("/user/index")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue="0") int page,
                        @RequestParam(name="size", defaultValue="5") int size,
                        @RequestParam(name="keyword", defaultValue="") String keyword){

        Page<Product> pageProducts =
                productRepository.findByNameContains(keyword, PageRequest.of(page,size));

        model.addAttribute("productList", pageProducts.getContent());
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "products";
    }

    // page d'accueil
    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }

    // supprimer produit (admin)
    @PostMapping("/admin/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@RequestParam(name="id") Long id){
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }

    // afficher formulaire ajout produit
    @GetMapping("/admin/newProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "new-product";
    }

    // sauvegarder produit
    @PostMapping("/admin/saveProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveProduct(@Valid Product product,
                              BindingResult bindingResult,
                              Model model){

        if(bindingResult.hasErrors())
            return "new-product";

        productRepository.save(product);
        return "redirect:/user/index";
    }

    // modifier produit
    @GetMapping("/admin/editProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String editProduct(Model model, @RequestParam Long id){

        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);

        return "new-product";
    }

    // page login
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // logout
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}