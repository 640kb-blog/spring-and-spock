package club.kb640;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
