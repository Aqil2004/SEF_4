import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class PostTest_1 {
    
    @Test

    public void postTest(){
        String postTitle = "Could I Get Java Help"; //Replace with post title data
        String tags_string = "java, c++"; //Replace with post tags data
        String type = "Easy"; //Repalce with post type data
        String emergency = "Ordinary"; //Replace with post emergency data
        String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor."; 
        //Replace with post content data

        String[] tags = tags_string.split(",");
        Post post = new Post(1, postTitle, body, tags, type, emergency);
        assertEquals(true, post.addPost());   
    }
}
