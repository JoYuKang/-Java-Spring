package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponese;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    //http://localhost/api/server/hello
    //respone
    public UserResponese Hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name","asda")
                .queryParam("age",123)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponese> result = restTemplate.getForEntity(uri, UserResponese.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();

    }

    public UserResponese post(){
        //localhost:9090/api/server/user{userId}/name/{userName}
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"steve") //expand는 하나만 사용
                .toUri();

        System.out.println(uri);

        //보내고 싶은 데이터
        //http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("크란");
        req.setAge(22);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponese> response = restTemplate.postForEntity(uri,req,UserResponese.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();

    }


    public UserResponese exchage(){
        //localhost:9090/api/server/user{userId}/name/{userName}
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"steve") //expand는 하나만 사용
                .toUri();


        //보내고 싶은 데이터
        //http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("크란");
        req.setAge(22);


        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header" , "fffff")
                .body(req);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserResponese> response = restTemplate.exchange(requestEntity,UserResponese.class);

        return response.getBody();
    }

    public Req<UserResponese> genericExchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"steve") //expand는 하나만 사용
                .toUri();

        //보내고 싶은 데이터
        //http body -> object -> object mapper -> json -> rest template -> http body json
        UserRequest userRequest = new UserRequest();
        userRequest.setName("크란");
        userRequest.setAge(22);

        Req<UserRequest> req = new Req<>();
        req.setHeader(
                    new Req.Header()

        );

        req.setrBody(
                userRequest
        );

        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header" , "fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<Req<UserResponese>> response
                = restTemplate.exchange(requestEntity,new ParameterizedTypeReference<>(){});

        return response.getBody();

    }

}
