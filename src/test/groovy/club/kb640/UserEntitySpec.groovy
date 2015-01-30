package club.kb640

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 *
 * @author Alexander
 */
@IntegrationTest
@ContextConfiguration(classes = [TestAppConfig])
class UserEntitySpec extends Specification {

    @Autowired
    UserRepository repository

    def "test save operation for entity - User"() {
        setup:
        def user = new User(firstName: "John", lastName: "Doe")

        when:
        repository.save(user)

        then:
        repository.count() == 1

        cleanup:
        repository.deleteAll()

    }

    def "test delete operation for entity - User"() {
        setup:
        def user = new User(firstName: "John", lastName: "Doe")
        repository.save(user)

        when:
        repository.count() == 1

        repository.delete(user.id)

        then:
        repository.count() == 0

        cleanup:
        repository.deleteAll()
    }
}
