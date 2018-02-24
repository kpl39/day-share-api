package com.dayshare.events;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/events")
public class EventController {

    @Autowired
    private EventRepository eventRepo;

    @RequestMapping(value = "/getevents/{parentId}/{groupId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getEventsByGroupId(@PathVariable int parentId, @PathVariable int groupId) {

        Set<Event> events = eventRepo.findByGroupId(parentId, groupId);

        HashMap<String, List<Event>> calendarEvents = new HashMap<String, List<Event>>();



        events.forEach(event -> {
            DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
            String dateString = df.format(event.getEventDate());

            if (!calendarEvents.containsKey(dateString)) {
                List<Event> dayEvents = new ArrayList<>();
                calendarEvents.put(dateString, dayEvents);
            };

            calendarEvents.get(dateString).add(event);

        });

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String eventsString = gson.toJson(calendarEvents);


        return new ResponseEntity<String>(eventsString, HttpStatus.OK);
    }
}
