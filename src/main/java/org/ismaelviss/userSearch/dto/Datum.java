package org.ismaelviss.userSearch.dto;

import java.util.Objects;

public class Datum {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String picture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Datum)) return false;

        Datum datum = (Datum) o;

        if (!Objects.equals(id, datum.id)) return false;
        if (!Objects.equals(title, datum.title)) return false;
        if (!Objects.equals(firstName, datum.firstName)) return false;
        if (!Objects.equals(lastName, datum.lastName)) return false;
        return Objects.equals(picture, datum.picture);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
