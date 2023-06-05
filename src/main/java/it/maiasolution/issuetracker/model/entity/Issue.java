package it.maiasolution.issuetracker.model.entity;


//@Entity
public class Issue {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subject;
    private String text;
    private String owner;

    public Issue() {
    }

    public Issue(String subject, String text, String owner) {
        this.subject = subject;
        this.text = text;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
} 