package com.mtsmda.souvenir.controller.restController;

import com.mtsmda.souvenir.model.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 3/18/2016.
 */
@RestController
public class TestRestController {

    public static int post = 0;
    public static int pre = 0;

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

    public static void main(String[] args) {
        List<Day> days = new ArrayList<>();

        for(Day day : Day.values()){
            if(!day.equals(Day.TUESDAY)){
                days.add(day);
            }
        }
        System.out.println(days);
    }

    @RequestMapping(value = "/messages")
    public List<Message> messages(){
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Message 1", "ivan.ivanov@gmail.com", "This is message text", 2));
        messages.add(new Message("Message 2", "ivan2.ivanov@gmail.com", "This is message text 2", 42));
        messages.add(new Message("Message 3", "ivan3.ivanov@gmail.com", "This is message text 3", 2));
        messages.add(new Message("Message 4", "ivan4.ivanov@gmail.com", "This is message text 4", 8));
        messages.add(new Message("Message 5", "ivan5.ivanov@gmail.com", "This is message text 5", 9));
        return messages;
    }

    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public List<Message> messages(@RequestBody List<Message> messages){
        for (Message message : messages){
            System.out.println(message.toString());
        }
        return messages;
    }

}

enum Day{
    MONDAY,
    TUESDAY,
    WEDNESDAY

}