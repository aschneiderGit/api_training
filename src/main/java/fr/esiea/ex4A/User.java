package fr.esiea.ex4A;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {

    public final String mail;
    public final String twitter;
    public final String username;
    public final String country;
    public final String sex;
    public final String sexPref;

    public User(@JsonProperty("userEmail") String mail, @JsonProperty("userName") String username, @JsonProperty("userTweeter") String twitter,
                @JsonProperty("userCountry") String country, @JsonProperty("userSex") String sex, @JsonProperty("userSexPref") String sexPref) {
        this.mail = mail;
        this.username = username;
        this.twitter = twitter;
        this.country = country;
        this.sex = sex;
        this.sexPref = sexPref;
    }
    @Override
    public String toString() {
        return "User{" +
            "mail='" + mail + '\'' +
            ", twitter='" + twitter + '\'' +
            ", username='" + username + '\'' +
            ", country='" + country + '\'' +
            ", sex='" + sex + '\'' +
            ", sexPref='" + sexPref + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(mail, user.mail) && Objects.equals(twitter, user.twitter) && Objects.equals(username, user.username) && Objects.equals(country, user.country) && Objects.equals(sex, user.sex) && Objects.equals(sexPref, user.sexPref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, twitter, username, country, sex, sexPref);
    }
}
