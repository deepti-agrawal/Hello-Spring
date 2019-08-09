package com.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");
        if(name == null)
            name = "World";
        return "Hello "+name;
    }

    @RequestMapping(value="hello",method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='POST'>"+
                "<input type='text' name='name'>"+
                "<select name='language'>"+
                    "<option value='English'>English</option>"+
                    "<option value='Hindi'>Hindi</option>"+
                    "<option value='French'>French</option>"+
                    "<option value='German'>German</option>"+
                    "<option value='Russian'>Russian</option>"+
                "</select>"+
                "<input type='submit' value='Greet Me'>"+
                "</form>";
        return html;
    }

    @RequestMapping(value="hello",method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String message = createMessage(language);
        return "<h2>"+message+" "+name+"</h2>";
    }

    @RequestMapping(value="/hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodBye(){
        return "GoodBye";
    }

    public static String createMessage(String language){
        String message="";
        if (language.equals("English"))
            message = "Hello";
        else if (language.equals("Hindi"))
            message = "नमस्ते";
        else if (language.equals("French"))
            message = "Bonjour";
        else if (language.equals("German"))
            message = "Hallo";
        else if (language.equals("Russian"))
            message = "Привет";
        return message;
    }
}
