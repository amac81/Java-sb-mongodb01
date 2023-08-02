package pt.bitclinic.Javasbmongodb01.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeResource {

   @GetMapping
   public String getWelcomeMessage() {
       return "Welcome to my Java Spring Boot Project with Mongodb application!";
   }
}