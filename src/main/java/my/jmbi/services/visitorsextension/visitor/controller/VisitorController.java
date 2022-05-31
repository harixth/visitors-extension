package my.jmbi.services.visitorsextension.visitor.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import my.jmbi.services.visitorsextension.visit.entity.Visit;
import my.jmbi.services.visitorsextension.visitor.entity.Visitor;
import my.jmbi.services.visitorsextension.exception.VisitorNotFoundException;
import my.jmbi.services.visitorsextension.visitor.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService service;

    @PostMapping(path ="/visitors")
    public ResponseEntity<Object> createVisitor(@Valid @RequestBody Visitor body) {
        Visitor savedVisitor = service.create(body);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedVisitor.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path ="/visitors")
    public List<Visitor> retrieveAllVisitors() {
        return service.findAll();
    }

    @GetMapping(path ="/visitors/{id}")
    public EntityModel<Visitor>  retrieveVisitor(@PathVariable String id) {
        Visitor savedVisitor = service.findOne(id);
        if (savedVisitor == null) {
            throw new VisitorNotFoundException("");
        }
        EntityModel<Visitor> model = EntityModel.of(savedVisitor);
        WebMvcLinkBuilder linkToVisitors = linkTo(methodOn(this.getClass()).retrieveAllVisitors());
        model.add(linkToVisitors.withRel("all-visitors"));
        return model;
    }

    @GetMapping(path ="/visitors/{id}/visits")
    public List<Visit> retrieveVisits(@PathVariable String id) {
         return service.findVisitsByVisitor(id);
    }

    @DeleteMapping(path= "/visitors/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteById(id);
    }
}
