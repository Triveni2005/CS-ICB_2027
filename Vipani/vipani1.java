public class vipani1 {
        @Entity
        public class Product {
                @Id
                @GeneratedValue
                private Long id;
                private String name;
                private String description;
                private double price;
                private String category;
                private String imageUrl;

                @ManyToOne
                private User seller;
        }
}
