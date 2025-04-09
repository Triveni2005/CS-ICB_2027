public class vipani4 {
        @Controller
        public class HomeController {
                @Autowired
                ProductRepository productRepo;

                @GetMapping("/")
                public String home(Model model) {
                        model.addAttribute("products", productRepo.findAll());
                        return "home";
                }
        }
}
