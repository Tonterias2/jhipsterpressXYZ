package com.jhipsterpress.web.service.mapper;

import com.jhipsterpress.web.domain.*;
import com.jhipsterpress.web.service.dto.PhotoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Photo and its DTO PhotoDTO.
 */
@Mapper(componentModel = "spring", uses = {AlbumMapper.class, CalbumMapper.class, UserMapper.class})
public interface PhotoMapper extends EntityMapper<PhotoDTO, Photo> {

    @Mapping(source = "album.id", target = "albumId")
    @Mapping(source = "calbum.id", target = "calbumId")
    @Mapping(source = "album.user.id", target = "albumUserId")
    @Mapping(source = "calbum.community.user.id", target = "calbumUserId")
    PhotoDTO toDto(Photo photo);

    @Mapping(source = "albumId", target = "album")
    @Mapping(source = "calbumId", target = "calbum")
    @Mapping(source = "albumUserId", target = "album.user.id")
    @Mapping(source = "calbumUserId", target = "calbum.community.user.id")
    Photo toEntity(PhotoDTO photoDTO);

    default Photo fromId(Long id) {
        if (id == null) {
            return null;
        }
        Photo photo = new Photo();
        photo.setId(id);
        return photo;
    }
}
