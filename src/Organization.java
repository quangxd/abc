import java.util.List;

public class Organization {
    private Long id;
    private Long parentId;
    private List<Organization> organization;

    public Organization() {
    }

    public Organization(Long id, Long parentId, List<Organization> organization) {
        this.id = id;
        this.parentId = parentId;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Organization> getOrganization() {
        return organization;
    }

    public void setOrganization(List<Organization> organization) {
        this.organization = organization;
    }
}
