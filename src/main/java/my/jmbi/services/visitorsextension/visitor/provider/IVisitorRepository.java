package my.jmbi.services.visitorsextension.visitor.provider;

import my.jmbi.services.visitorsextension.visitor.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVisitorRepository extends JpaRepository<Visitor, Integer> {}
