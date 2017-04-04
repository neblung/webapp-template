package template.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("feedback")
public class FeedbackResource {
    @GET
    @Path("headers")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ?> getHeaders(@Context HttpHeaders httpHeaders) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("requestHeaders", httpHeaders.getRequestHeaders());
        return result;
    }

    @GET
    @Path("servletRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getFeedback(@Context HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("requestURI", request.getRequestURI());
        map.put("serverName", request.getServerName());
        map.put("contextPath", request.getContextPath());
        map.put("servletPath", request.getServletPath());
        map.put("pathInfo", request.getPathInfo());
        map.put("parameters", request.getParameterMap());
        return map;
    }
}
