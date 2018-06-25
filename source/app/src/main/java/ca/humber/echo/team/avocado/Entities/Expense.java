package ca.humber.echo.team.avocado.Entities;

import java.util.Date;

/**
 * Entity Java Bean class
 */
public class Expense {

    private Long id;
    private Double value;
    private String descriprion;
    private Date date;
    private Long categoryId;
    private Long subcategoryId;

    public Expense(Long id, Double value, String descriprion, Date date, Long categoryId, Long subcategoryId) {
        this.id = id;
        this.value = value;
        this.descriprion = descriprion;
        this.date = date;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
