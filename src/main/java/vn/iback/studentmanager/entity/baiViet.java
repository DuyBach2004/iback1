package vn.iback.studentmanager.entity;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "bai_viet")
public class baiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_baiviet")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name = "image")
    private Blob image;
    @Column(name = "like")
    private int like;
    @Column(name = "tim")
    private int tim;
    @Column(name = "haha")
    private int haha;
    @Column(name = "dislike")
    private int dislike;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "username")
    private user user;

    public baiViet(int id, String title, String content, Blob image, int like, int tim, int haha, int dislike, vn.iback.studentmanager.entity.user user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.like = like;
        this.tim = tim;
        this.haha = haha;
        this.dislike = dislike;
        this.user = user;
    }

    public baiViet() {
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getTim() {
        return tim;
    }

    public void setTim(int tim) {
        this.tim = tim;
    }

    public int getHaha() {
        return haha;
    }

    public void setHaha(int haha) {
        this.haha = haha;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public vn.iback.studentmanager.entity.user getUser() {
        return user;
    }

    public void setUser(vn.iback.studentmanager.entity.user user) {
        this.user = user;
    }
}
