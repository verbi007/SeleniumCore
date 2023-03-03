package entities;


import lombok.Data;

import java.util.ArrayList;

@Data
public class Character {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private String[] episode;
    private String url;
    private String created;

}
