package com.avenuecode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.plus.PeoplePage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ac-jlima on 11/30/15.
 */

@Controller
@RequestMapping(value = "/plus", method = RequestMethod.GET)
public class PlusController {

    private Google google;

    @Autowired
    public PlusController(Google google) {
        this.google = google;
    }

    @ResponseBody
    @RequestMapping("/people")
    public PeoplePage searchPeople(String query, @RequestParam(required = false) String pageToken) {
        return google.plusOperations().searchPeople(query, pageToken);
    }

}
