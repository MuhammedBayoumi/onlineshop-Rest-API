package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}