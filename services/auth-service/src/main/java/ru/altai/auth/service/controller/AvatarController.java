package ru.altai.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.altai.auth.service.entity.Avatar;
import ru.altai.auth.service.repository.AvatarRepository;
import ru.altai.auth.api.dao.AvatarControllerDao;
import ru.altai.service.api.exeption.EntityNotFoundException;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class AvatarController implements AvatarControllerDao<Avatar> {

    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public byte[] findImage(@Min(1) Long id, Map<String, Object> params) {
        Integer height = params.get("height") != null && !params.get("height").toString().isEmpty()? Integer.valueOf(params.get("height").toString()): null;
        Integer width = params.get("width") != null && !params.get("width").toString().isEmpty()? Integer.valueOf(params.get("width").toString()): null;

        Avatar avatar = avatarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        if (width != null) {
            switch (width) {
                case 50: return avatar.getImage50x50();
                case 100: return avatar.getImage100x100();
                case 200: return avatar.getImage200x200();
                case 300: return avatar.getImage300x300();
                case 400: return avatar.getImage400x400();
                case 500: return avatar.getImage500x500();
                default: return avatar.getImage();
            }
        } else return avatar.getImage();
    }

    @Override
    public List<Avatar> findAll() {
        List<Avatar> list = new ArrayList<>();
        avatarRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Avatar find(@Min(1) Long id) {
        return avatarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Avatar create(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    @Override
    public Avatar update(@Min(1) Long id, Avatar newAvatar) {
        return avatarRepository.findById(id)
            .map(avatar -> {
                avatar.setImage(newAvatar.getImage());
                return avatarRepository.save(avatar);
            }).orElseGet(() -> {
                newAvatar.setId(id);
                return avatarRepository.save(newAvatar);
            });
    }

    @Override
    public void delete(@Min(1) Long id) {
        avatarRepository.deleteById(id);
    }

}
