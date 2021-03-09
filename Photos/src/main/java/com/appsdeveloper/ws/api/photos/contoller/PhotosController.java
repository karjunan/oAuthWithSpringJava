package com.appsdeveloper.ws.api.photos.contoller;

import com.appsdeveloper.ws.api.photos.domain.PhotosRest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/photos")
public class PhotosController {

    @GetMapping
    public List<PhotosRest> status() {
        List<PhotosRest> list = new ArrayList<>();
        PhotosRest photosRest = new PhotosRest();
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
