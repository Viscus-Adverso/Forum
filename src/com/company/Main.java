package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();

        File f = new File("posts.txt");
        ArrayList<Post> posts = loadPosts(f);

        Scanner consoleScanner = new Scanner(System.in);

        int readId = -1;
        while (true) {
            printPosts(post, replyId);


        }
    }

    public static void ArrayList<Post> loadPosts(File f)throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            String replyId = columns[0];
            String author = columns[1];
            String text = columns[2];
            Post p = new Post(Integer.valueOf(replyId), author, text);
            posts.add(p);
        }
        return posts;
    }

    public static void printPosts(ArrayList<Post> posts, int replyId) {
        System.out.println("Posts repyling to " +  replyId);
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            if (post.replyId == replyId) {
                System.out.printf("[%s] %s by %s\n", i, post.text, post.author);
            }
        }
    }

    public static int readId(Scanner consoleScanner){
        System.out.println("Type the id you want to see replies to:");
        return Integer.valueOf(consoleScanner.nextLine());
    }
}
