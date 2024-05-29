package SEF_4;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postType;
    private String postEmergency;
    private ArrayList <String> postComments = new ArrayList<>();
    private int comment_count;
    
    public Post(int id, String title, String body, String[] tags , String type, String emergency){
        this.postID = id;
        this.postTitle = title;
        this.postBody = body;
        this.postTags = tags;
        this.postType = type;
        this.postEmergency = emergency;
    }
    

    public void postID(int id){
        this.postID = id;
    }
    public void postTitle(String title){
        this.postTitle = title;
    }
    public void postTags(String[] tags){
        this.postTags = tags;
    }
    public void postBody(String body){
        this.postBody = body;
    }
    public void postType(String type){
        this.postType = type;
    }
    public void postEmergency(String emergency){
        this.postEmergency = emergency;
    }

    private boolean addPost_condition_1(){
        String str = postTitle.substring(0, 5);
        if(postTitle.length() >= 10 && postTitle.length() <= 250){
            for(int i = 0; i < 5; i++){
                if(!Character.isLetter(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    private boolean addPost_condition_2(){
        if(postBody.length() >= 250){
            return true;
        }
        return false;
    }
    private boolean addPost_condition_3(){
        if(postTags.length >= 2 && postTags.length <= 5){
            for(String tag: postTags){
                if(tag.length() >= 2 && tag.length() <= 10){
                    for(int i = 0; i < tag.length(); i++){
                        if(Character.isUpperCase(tag.charAt(i))){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean addPost_condition_4(){
        if(postType == "Easy"){
            if(postTags.length <= 3){
                return true;
            }
        }else{
            if(postTags.length >= 300){
                return true;
            }
        }
        return false;
    }
    private boolean addPost_condition_5(){
        if(postType == "Easy"){
            if(postEmergency == "Ordinary"){
                return true;
            }
        }else{
            if(postEmergency != "Ordinary"){
                return true;
            }
        }
        return false;
    }
        
    private boolean addComment_condition_1(String comment){
        int word_count = comment.split(" ").length;
        if(word_count >= 4 && word_count <= 10 && Character.isUpperCase(comment.charAt(0))){
            return true;
        }
        return false;
    }

    private boolean addComment_condition_2(){
        if(postType == "Easy" || postEmergency == "Ordinary"){
            if(postComments.size() < 3){
                return true;
            }
        }else{
            if(postComments.size() < 5){
                return true;
            }
        }
        return false;
    }

    public boolean addPost()
    {
        if(addPost_condition_1() && addPost_condition_2() && addPost_condition_3() && addPost_condition_4() && addPost_condition_5()){
            File post = new File("post.txt");
            try {
                post.createNewFile();
                String fileContent = Integer.toString(postID) + "\n" + postTitle + "\n" + postBody + "\n" + String.join(",", postTags) + "\n" + postType + "\n" + postEmergency + "\n" + postComments;
                FileWriter writer = new FileWriter("post.txt");
                writer.write(fileContent);
                writer.close();
            }catch (IOException e){
                System.err.println("An error occured!");
            }
            return true;
        }
        return false;
    }
    public boolean addComment(String content)
    {
        comment_count++;
        int commentID = comment_count;
        String commentBody = content;
        if(addComment_condition_1(commentBody) && addComment_condition_2()){
            try {
                String post_file_name = Integer.toString(postID) + " - " + Integer.toString(commentID);
                String fileContent = Integer.toString(postID) + "\n" + Integer.toString(commentID) + "\n" + commentBody;
                FileWriter writer = new FileWriter(post_file_name);
                writer.write(fileContent);
                writer.close();
                postComments.add(post_file_name);
            }catch (IOException e){
                System.err.println("An error occured!");
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner post_input_obj = new Scanner(System.in);
        System.out.println("Enter title of Post:");
        String titleName = post_input_obj.nextLine();
        System.out.println("Enter content of Post:");
        String postBody = post_input_obj.nextLine();
        System.out.println("Enter tags of Post (Seperated by a comma):");
        String[] postTags = post_input_obj.nextLine().split(",");
        System.out.println("Enter type of Post: ('Very Difficult, Difficult, Easy')");
        String postType = post_input_obj.nextLine();
        System.out.println("Enter emergency level of Post: (Immediately Needed, Highly Needed, Ordinary)");
        String postEmergency = post_input_obj.nextLine();
        int id = postBody.length();
        Post post = new Post(id, titleName, postBody, postTags, postType, postEmergency);
        post.addPost();
        System.out.println("Would you like to add comments? (y/n)");
        while(post_input_obj.nextLine() == "y"){
            System.out.println("Enter content of Comment:");
            String comment = post_input_obj.nextLine();
            post.addComment(comment);
            System.out.println("Would you like to add another comment? (y/n)");
        }
        post_input_obj.close();
    }
}
