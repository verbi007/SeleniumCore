package entities;

import lombok.Data;

@Data
public class Location {
    private Integer id;
    private String name;
    private String type;
    private String dimension;
    private String[] residents;
    private String url;
    private String created;
}
