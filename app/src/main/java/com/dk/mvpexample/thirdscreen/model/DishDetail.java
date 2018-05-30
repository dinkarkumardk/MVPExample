package com.dk.mvpexample.thirdscreen.model;

/**
 * Created by dinkark on 26/05/18.
 */


public class DishDetail {
    private String cuisine;

    private String hasBranches;

    private String established;

    private String pic;

    private String country;

    private String city;

    private String _id;

    private String updated;

    private String email;

    private String address;

    private String name;

    private String slug;

    private String longitude;

    private String latitude;

    private String rating;

    private String[] comments;

    private String tagline;

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getHasBranches() {
        return hasBranches;
    }

    public void setHasBranches(String hasBranches) {
        this.hasBranches = hasBranches;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @Override
    public String toString() {
        return "ClassPojo [cuisine = " + cuisine + ", hasBranches = " + hasBranches + ", established = " + established + ", pic = " + pic + ", country = " + country + ", city = " + city + ", _id = " + _id + ", updated = " + updated + ", email = " + email + ", address = " + address + ", name = " + name + ", slug = " + slug + ", longitude = " + longitude + ", latitude = " + latitude + ", rating = " + rating + ", comments = " + comments + ", tagline = " + tagline + "]";
    }
}


