package de.evaspringbuch.eva10transaction.tryTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wogo on 21.03.16.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByName(String name);
}


