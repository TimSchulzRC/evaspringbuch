package de.evaspringbuch.eva09aop.tryAopProxy;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface SomeEntityRepository extends JpaRepository<SomeEntity, Integer> {
}
