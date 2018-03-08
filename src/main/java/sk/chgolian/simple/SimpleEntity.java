package sk.chgolian.simple;

import javax.persistence.*;

import static sk.chgolian.simple.SimpleEntity.SIMPLE_QUERY;

@Entity
@Table(name = "SIMPLE_TABLE")
@NamedQuery(
        name = SIMPLE_QUERY,
        query = "SELECT new sk.chgolian.simple.ShortInfo(se.id, se.shortDescription) FROM sk.chgolian.simple.SimpleEntity se")
public class SimpleEntity {
    public final static String SIMPLE_QUERY = "simpleQuery";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;

    @Column(name = "LONG_DESCRIPTION")
    private String longDescription;

    public SimpleEntity(String shortDescription, String longDescription) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
