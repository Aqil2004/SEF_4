package SEF_4;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CommentTest_1 {
    
    @Test

    public void CommentTest(){
        String postTitle = "MyFirstPost";
        String tags_string = "java, c++";
        String type = "Easy";
        String emergency = "Ordinary"; 
        String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor."; 

        
        String comment = "Consectetur adipiscing elit, sed do eiusmod"; //Replace with comment body
        int additional_comments = 0;
        String[] tags = tags_string.split(",");
        Post post = new Post(1, postTitle, body, tags, type, emergency);
        for(int count = 0; count < additional_comments; count++){
            post.addComment(comment);
        }
        assertEquals(true, post.addComment(comment));   
    }
}
