package ca.humber.echo.team.avocado.Entities;

/**
 * Entity Java Bean class
 */
public class Category {

    private Long id;
    private String name;
    private Long referenceId;

    public Category(Long id, String name, Long referenceId) {
        this.id = id;
        this.name = name;
        this.referenceId = referenceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }
}
