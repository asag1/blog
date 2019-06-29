package lt.codeacademy.blog.post;

import lt.codeacademy.blog.comment.Comment;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostView {

    private Long id;

    private String title;

    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private List<Comment> comments = new ArrayList<>();

    public PostView() {
    }

    public PostView(Long id, String title, String text, LocalDate date, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PostView{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostView postView = (PostView) o;
        return Objects.equals(id, postView.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
