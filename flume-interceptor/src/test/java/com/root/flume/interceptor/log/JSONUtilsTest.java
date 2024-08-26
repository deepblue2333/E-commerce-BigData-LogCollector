package com.root.flume.interceptor.log;

import org.junit.Test;
import static org.junit.Assert.*;

public class JSONUtilsTest {

    @Test
    public void testIsJSONValidate() {
        // Valid JSON strings
        assertTrue(JSONUtils.isJSONValidate("{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}"));
        assertTrue(JSONUtils.isJSONValidate("[{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}]"));
        assertTrue(JSONUtils.isJSONValidate("{\"name\":\"John\"}"));
        assertTrue(JSONUtils.isJSONValidate("[]"));
        assertTrue(JSONUtils.isJSONValidate("{}"));
        assertTrue(JSONUtils.isJSONValidate(""));
        assertTrue(JSONUtils.isJSONValidate("{name:\"John\", age:30, city:\"New York\"}"));

        // Invalid JSON strings
        assertFalse(JSONUtils.isJSONValidate("[{\"name\":\"John\", \"age\":30, \"city\":\"New York\"]"));
        assertFalse(JSONUtils.isJSONValidate("{\"name\":\"John\", \"age\":30, \"city\":\"New York\""));
        assertFalse(JSONUtils.isJSONValidate("This is not a JSON string"));
    }
}