package com.sda.todo;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-06-12.
 */
public class TodoUtils {

    public static boolean IsWriteRequest(HttpServletRequest req) {
        Map<String, String[] > parameterMap = req.getParameterMap();
//        return parameterMap.containsKey("name") &&
//        parameterMap.containsKey("description") &&
//        parameterMap.containsKey("priority") &&
//        parameterMap.containsKey("date");
        return exists("name", parameterMap) &&
                exists("description", parameterMap) &&
                exists("priority", parameterMap) &&
                exists("date", parameterMap);

    }

    private static boolean exists(String param, Map<String, String[]> map) {
        return map.containsKey(param) && StringUtils.isNotEmpty(map.get(param)[0]);
    }

}
