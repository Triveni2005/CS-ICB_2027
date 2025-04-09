public class vipani5 {
        @Controller
        @RequestMapping("/seller")
        public class ProductController {
                @Autowired
                ProductRepository productRepo;
                @Autowired
                UserRepository userRepo;

                @GetMapping("/add-product")
                public String addProductForm(Model model) {
                        model.addAttribute("product", new Product());
                        return "add-product";
                }

                @PostMapping("/add-product")
                public String addProduct(@ModelAttribute Product product, Principal principal) {
                        User seller = userRepo.findByUsername(principal.getName());
                        product.setSeller(seller);
                        productRepo.save(product);
                        return "redirect:/";
                }
        }
}
