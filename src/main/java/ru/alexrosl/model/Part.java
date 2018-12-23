package ru.alexrosl.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private int quantity;

    @Column(nullable = false, columnDefinition = "bit")
    private boolean required;

    @Column
    private Date created;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}
