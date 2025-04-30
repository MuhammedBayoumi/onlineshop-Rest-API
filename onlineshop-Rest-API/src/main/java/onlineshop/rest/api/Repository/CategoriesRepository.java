package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
}