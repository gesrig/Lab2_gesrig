package com.example.gregoryesrig24.lab2_gesrig;

/**
 * Created by gregoryesrig24 on 4/18/17.
 */

public class Image {

    private int _id;
    private int game_id;
    private String uri;
    private byte[] image;

    public Image(int _id, int game_id,  String uri, byte[] image) {
        this._id = _id;
        this.game_id = game_id;
        this.uri = uri;
        this.image = image;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_book_id() {
        return game_id;
    }

    public void set_book_id(int _id) {
        this.game_id = game_id;
    }

    public String get_uri() {
        return uri;
    }

    public void set_uri(String uri) {
        this.uri = uri;
    }

    public byte[] get_image() {
        return image;
    }

    public void set_image(byte[] image) {
        this.image = image;
    }
}