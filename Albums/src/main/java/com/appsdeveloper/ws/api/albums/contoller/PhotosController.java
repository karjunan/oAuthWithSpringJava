package com.appsdeveloper.ws.api.albums.contoller;

import com.appsdeveloper.ws.api.albums.domain.AlbumsRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/albums")
public class PhotosController {

    @GetMapping
    public List<AlbumsRest> status() {
        List<AlbumsRest> list = new ArrayList<>();
        AlbumsRest photosRest = new AlbumsRest();
        photosRest.setAlbumId(UUID.randomUUID().toString());
        photosRest.setAlbumName("My Album");
        photosRest.setPhotoDescription("Family photos");
        photosRest.setPhotoTitle("Family");
        photosRest.setPhotoUrl("http://localhost:0000");
        photosRest.setUserId(UUID.randomUUID().toString());
        list.add(photosRest);
        return list;

    }

}
