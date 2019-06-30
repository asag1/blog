package lt.codeacademy.blog.comment;

import lt.codeacademy.blog.post.Post;

import java.time.LocalDate;
import java.util.Objects;


public class CommentView {

    private Long id;

    private String comment;

    private LocalDate data;

    private String answer;

    private Post post;

    public CommentView() {
    }

    public CommentView(Long id, String comment, LocalDate data, String answer, Post post) {
        this.id = id;
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
        return "CommentView{" +
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
        CommentView that = (CommentView) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
