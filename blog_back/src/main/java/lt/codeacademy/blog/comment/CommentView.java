package lt.codeacademy.blog.comment;

import lt.codeacademy.blog.post.Post;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class CommentView {

    private Long id;

    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Post post;

    private CommentRating rating;

    public CommentView() {
    }

    public CommentView(Long id, String comment, LocalDate date, Post post, CommentRating rating) {
        this.id = id;
        this.comment = comment;
        this.date = date;
        this.post = post;
        this.rating = rating;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public CommentRating getRating() {
        return rating;
    }

    public void setRating(CommentRating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CommentView{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", post=" + post +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentView that = (CommentView) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
