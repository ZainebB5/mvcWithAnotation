package be.intecbrussel.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id", nullable = false)
    private UserEntity sender;

    @ManyToMany
    @JoinTable(name = "chats",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "receiver_id"))
    private Set<UserEntity> receivers = new LinkedHashSet<>();


    @Column(name = "subject", nullable = false)
    private String subject;

    @NotBlank
    @NotNull
    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "views_count")
    private Integer viewsCount;

    @Column(name = "likes_count")
    private Integer likesCount;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    public MessageEntity() {
    }

    public MessageEntity( UserEntity sender, Set<UserEntity> receivers, String subject, String content, Integer viewsCount, Integer likesCount, Boolean active) {
        this.sender = sender;
        this.receivers = receivers;
        this.subject = subject;
        this.content = content;
        this.viewsCount = viewsCount;
        this.likesCount = likesCount;
        this.active = active;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public Set<UserEntity> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<UserEntity> receivers) {
        this.receivers = receivers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", sender=" + sender +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", viewsCount=" + viewsCount +
                ", likesCount=" + likesCount +
                ", active=" + active +
                '}';
    }
}