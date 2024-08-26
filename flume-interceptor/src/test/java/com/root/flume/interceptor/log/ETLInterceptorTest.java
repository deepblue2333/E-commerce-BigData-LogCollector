package com.root.flume.interceptor.log;

import com.alibaba.fastjson.JSON;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import org.apache.flume.event.EventBuilder;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ETLInterceptorTest {
    private ETLInterceptor interceptor;

    @Before
    public void setUp() {
        interceptor = new ETLInterceptor();
        interceptor.initialize();
    }

    @Test
    public void testValidJSONEvent() {
        String validJson = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        Event event = EventBuilder.withBody(validJson, StandardCharsets.UTF_8);

        Event result = interceptor.intercept(event);

        assertNotNull(result);
        assertEquals(validJson, new String(result.getBody(), StandardCharsets.UTF_8));
    }

    @Test
    public void testInvalidJSONEvent() {
        String invalidJson = "invalid json";
        Event event = EventBuilder.withBody(invalidJson, StandardCharsets.UTF_8);

        Event result = interceptor.intercept(event);

        assertNull(result);
    }

    @Test
    public void testInterceptList() {
        List<Event> events = new ArrayList<>();
        String validJson = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        String invalidJson = "invalid json";

        events.add(EventBuilder.withBody(validJson, StandardCharsets.UTF_8));
        events.add(EventBuilder.withBody(invalidJson, StandardCharsets.UTF_8));

        List<Event> result = interceptor.intercept(events);

        assertEquals(1, result.size());
        assertEquals(validJson, new String(result.get(0).getBody(), StandardCharsets.UTF_8));
    }
}