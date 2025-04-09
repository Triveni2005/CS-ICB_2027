public class vipani {
        @Entity
        public class User {
                @Id
                @GeneratedValue
                private Long id;
                private String username;
                private String password;
                private String role; // SELLER or BUYER
        }
}
