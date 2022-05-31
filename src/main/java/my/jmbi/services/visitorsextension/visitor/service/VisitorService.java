package my.jmbi.services.visitorsextension.visitor.service;

import my.jmbi.services.visitorsextension.visit.entity.Visit;
import my.jmbi.services.visitorsextension.visitor.entity.Visitor;
import my.jmbi.services.visitorsextension.visitor.provider.IVisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VisitorService {

    @Autowired
    private IVisitorRepository visitorRepository;

    public Visitor create(Visitor visitor) {
        Visitor newVisitor = new Visitor(visitor.getName(), visitor.getPhone());
        return visitorRepository.save(newVisitor);
    }

    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }

    public Visitor findOne(String id) {
        Integer vid = Integer.parseInt(id);
        Optional<Visitor> visitor = visitorRepository.findById(vid);
        if (visitor.isPresent()) {
            return visitor.get();
        }
        return null;
    }

    public List<Visit> findVisitsByVisitor(String id) {
        Integer vid = Integer.parseInt(id);
        Optional<Visitor> visitor = visitorRepository.findById(vid);
        if (visitor.isPresent()) {
            return visitor.get().getVisits();
        }
        return null;
    }

    public void deleteById(String id) {
        Integer vid = Integer.parseInt(id);
        visitorRepository.deleteById(vid);
    }
}
