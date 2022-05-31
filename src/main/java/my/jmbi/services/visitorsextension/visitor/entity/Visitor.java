package my.jmbi.services.visitorsextension.visitor.entity;

import my.jmbi.services.visitorsextension.visit.entity.Visit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Visitor {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message="Name should have at least 2 characters")
    private String name;

    private Integer phone;

    @OneToMany(mappedBy = "visitor")
    private List<Visit> visits;

    public Visitor(String name, Integer phone) {
        this.name = name;
        this.phone = phone;
    }

    protected Visitor() {}

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
