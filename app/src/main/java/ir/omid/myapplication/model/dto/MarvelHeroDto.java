package ir.omid.myapplication.model.dto;

import com.google.gson.annotations.SerializedName;

public class MarvelHeroDto {

    @SerializedName("name")
    public String name;

    @SerializedName("realname")
    public String realName;

    @SerializedName("team")
    public String team;

    @SerializedName("imageurl")
    public String imageUrl;

    @SerializedName("bio")
    public String bio;

    public MarvelHeroDto(String name, String realName, String team, String imageUrl, String bio) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.imageUrl = imageUrl;
        this.bio = bio;
    }
}
