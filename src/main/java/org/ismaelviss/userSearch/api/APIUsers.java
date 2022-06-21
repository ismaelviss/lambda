package org.ismaelviss.userSearch.api;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.ismaelviss.userSearch.dto.ResponseUser;
import org.ismaelviss.userSearch.dto.User;

import java.util.List;
import java.util.Map;

@Headers({"Accept: application/json", "app-id: 62ae757ce0d22dc3a71570a0"})
public interface APIUsers {

    @RequestLine("GET /user")
    User users(@QueryMap Map<String, Object> query);
}
