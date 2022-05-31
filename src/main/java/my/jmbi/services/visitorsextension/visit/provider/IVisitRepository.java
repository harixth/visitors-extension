package my.jmbi.services.visitorsextension.visit.provider;

import my.jmbi.services.visitorsextension.visit.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisitRepository extends JpaRepository<Visit, Integer> {}
