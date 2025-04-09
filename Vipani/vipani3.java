public class vipani3 {
        public interface UserRepository extends JpaRepository<User, Long> {
                User findByUsername(String username);
        }

        public interface ProductRepository extends JpaRepository<Product, Long> {
                List<Product> findByCategory(String category);
        }

        public interface OrderRepository extends JpaRepository<Order, Long> {
                List<Order> findByBuyer(User buyer);
        }
}
