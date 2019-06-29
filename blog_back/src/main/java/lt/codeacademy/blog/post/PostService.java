package lt.codeacademy.blog.post;

import lt.codeacademy.blog.config.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {

    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    List<PostView> getPostView() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void updatePost(int id, PostView updatedPostView) {
        Post post = find(id);

        if (updatedPostView.getTitle() != null) {
            post.setTitle(updatedPostView.getTitle());
        }
        if (updatedPostView.getText() != null) {
            post.setText(updatedPostView.getText());
        }
        if (updatedPostView.getDate() != null) {
            post.setDate(updatedPostView.getDate());
        }
        if (updatedPostView.getComments() != null) {
            post.setComments(updatedPostView.getComments());
        }

        repository.save(post);
    }

    PostView addPost(PostView postView) {
        return mapToView(repository.save(mapFromView(postView)));
    }

    void deletePost(int id) {
        repository.deleteById(id);
    }

    private Post mapFromView(PostView postView) {
        return new Post(postView.getTitle(), postView.getText(), postView.getDate(), postView.getComments());
    }

    private Post find(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("PostView not found"));
    }

    private PostView mapToView(Post post) {
        return new PostView(post.getId(), post.getTitle(), post.getText(), post.getDate(), post.getComments());
    }
}
