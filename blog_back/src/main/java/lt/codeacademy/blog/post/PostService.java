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

    public Post save(Post post) {
        return repository.save(post);
    }

    List<PostView> getPostView() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void updatePost(int id, PostView updatedPostView) {
        Post post = findForId(id);

        if (updatedPostView.getTitle() != null) {
            post.setTitle(updatedPostView.getTitle());
        }
        if (updatedPostView.getText() != null) {
            post.setText(updatedPostView.getText());
        }
        if (updatedPostView.getComments() != null) {
            post.setComments(updatedPostView.getComments());
        }

        repository.save(post);
    }

    public PostView addPost(PostView postView) {
//        PostView post1 = mapFromView(postView);
//
//        post1.setDate(LocalDate.now());
        return mapToView(repository.save(mapFromView(postView)));
    }

    void deletePost(int id) {
        repository.deleteById(id);
    }

    private Post mapFromView(PostView postView) {
        return new Post(postView.getTitle(), postView.getText(), postView.getData(), postView.getComments());
    }

    private Post findForId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("PostView not found"));
    }

    private PostView mapToView(Post post) {
        return new PostView(post.getId(), post.getTitle(), post.getText(), post.getData(), post.getComments());
    }
}
