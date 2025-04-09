public class vipani2 {
        @Entity
        public class Order {
                @Id
                @GeneratedValue
                private Long id;
                private String status; // PENDING, SHIPPED

                @ManyToOne
                private User buyer;

                @ManyToMany
                private List<Product> products;
        }
}
