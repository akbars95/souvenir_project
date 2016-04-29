package com.mtsmda.souvenir.tests;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by dminzat on 4/25/2016.
 */
@Controller("postConstructorAndPreDestroy")
public class PostConstructorAndPreDestroy {

    private static int post = 0;
    private static int pre = 0;

    @PostConstruct
    public void init(){
        post++;
        System.out.println(post);
    }

    @PreDestroy
    public void destroy(){
        pre++;
        System.out.println(pre);
    }

    public static void setPost(int post) {
        PostConstructorAndPreDestroy.post = post;
    }

    public static void setPre(int pre) {
        PostConstructorAndPreDestroy.pre = pre;
    }

    public static int getPost() {
        return post;
    }

    public static int getPre() {
        return pre;
    }
}