package lt.codeacademy.blog.comment;

import lt.codeacademy.blog.post.Post;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull(message = "*Please write something")
    private String comment;

    @Column
    private LocalDate data;

    @Column
    private String answer;

    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_post_comment"))
    @NotNull
    private Post post;

    public Comment() {
    }

    public Comment(@NotNull(message = "*Please write something") String comment, LocalDate data, String answer, @NotNull Post post) {
        this.comment = comment;
        this.data = data;
        this.answer = answer;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentData=" + data +
                ", answer='" + answer + '\'' +
                ", post=" + post +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
