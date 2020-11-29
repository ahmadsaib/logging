package com.task.log;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sample")
public class SampleController {

    static org.slf4j.Logger logger = LoggerFactory.getLogger(SampleController.class.getName());

    @Value("${welcome.message}")
    private String welcomeMessage;


    @RequestMapping(value = "/getApi/{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    String getApi(@PathVariable("id") Long id) {
    String message = "value is: "+id;
        try {

            if(id.equals((long)0)){
                throw new Exception();
            }

            if(id.equals((long)100)){
                logger.debug("{} - debug: {}", welcomeMessage, "value should not be " + id);
                message =  "value should not be: " + id;

            }
            if(!id.equals((long)100)) {
                logger.info("{} - info: {}", welcomeMessage, "value is " + id);
                message =  "value is: " + id;
            }

        } catch (Exception e) {
            logger.debug("{} - debug: {}", welcomeMessage, "value should not be " + id);
            message =  "value should not be: " + id;
        }


        return welcomeMessage + " - " + message;
    }


}
