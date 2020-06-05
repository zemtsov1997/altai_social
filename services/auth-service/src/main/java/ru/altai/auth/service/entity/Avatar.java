package ru.altai.auth.service.entity;

import ru.altai.auth.api.model.IAvatar;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Avatar implements IAvatar {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] image;
    @Lob
    private byte[] image50x50;
    @Lob
    private byte[] image100x100;
    @Lob
    private byte[] image200x200;
    @Lob
    private byte[] image300x300;
    @Lob
    private byte[] image400x400;
    @Lob
    private byte[] image500x500;

    public Avatar() { }

    public Avatar(byte[] image) {
        this.setImage(image);
    }

    @Override
    public byte[] getImage() {
        return image;
    }
    @Override
    public void setImage(byte[] image) {
        this.image = image;
        this.resize();
    }
    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public byte[] getImage50x50() {
        return image50x50 != null? image50x50 : this.getImage();
    }
    @Override
    public void setImage50x50(byte[] image50x50) {
        this.image50x50 = image50x50;
    }
    @Override
    public byte[] getImage100x100() {
        return image100x100 != null? image100x100 : this.getImage50x50();
    }
    @Override
    public void setImage100x100(byte[] image100x100) {
        this.image100x100 = image100x100;
    }
    @Override
    public byte[] getImage200x200() {
        return image200x200 != null? image200x200 : this.getImage100x100();
    }
    @Override
    public void setImage200x200(byte[] image200x200) {
        this.image200x200 = image200x200;
    }
    @Override
    public byte[] getImage300x300() {
        return image300x300 != null ? image300x300 : this.getImage200x200();
    }
    @Override
    public void setImage300x300(byte[] image300x300) {
        this.image300x300 = image300x300;
    }
    @Override
    public byte[] getImage400x400() {
        return image400x400 != null? image400x400 : this.getImage300x300();
    }
    @Override
    public void setImage400x400(byte[] image400x400) {
        this.image400x400 = image400x400;
    }
    @Override
    public byte[] getImage500x500() {
        return image500x500 != null? image500x500 : this.getImage400x400();
    }
    @Override
    public void setImage500x500(byte[] image500x500) {
        this.image500x500 = image500x500;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar logo = (Avatar) o;
        return Arrays.equals(image, logo.image);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(image);
    }
}
