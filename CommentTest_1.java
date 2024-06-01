import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CommentTest_1 {
    
    @Test

    public void CommentTest(){
        //I have commented which variables can be changed for testing
        String postTitle = "Could I Get Java Help"; //Replace with 'postTitle' data
        String tags_string = "java, c++"; //Replace with 'tags_string' data
        String type = "Easy"; //Repalce with 'type' data
        String emergency = "Ordinary"; //Replace with 'emergency' data
        String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor."; 
        //^^Replace with 'body' data

        
        String comment = "Better write it in java code than python"; //Replace with 'commentBody' data
        int additional_comments = 0; //Replace with 'additional_comments' data

        String[] tags = tags_string.split(",");
        Post post = new Post(1, postTitle, body, tags, type, emergency);
        for(int count = 0; count < additional_comments; count++){
            post.addComment(comment);
        }
        assertEquals(true, post.addComment(comment));   
    }
}
