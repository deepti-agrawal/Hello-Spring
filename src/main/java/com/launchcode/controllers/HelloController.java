package com.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String helloPost(@RequestParam String name, @RequestParam String language){
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
        switch(language) {
            case "English":
                message = "Hello";
                break;
            case "Hindi":
                message = "नमस्ते";
                break;
            case "French":
                message = "Bonjour";
                break;
            case "German":
                message = "Hallo";
                break;
            case "Russian":
                message = "Привет";
                break;
        }
        return message;
    }
}
