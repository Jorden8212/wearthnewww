package com.example.davidhsu.sdweather.sqlDatabase;

/**
 * Created by David Hsu on 2015/9/15.
 */
import java.io.Serializable;

public class Spot {
    private int id;
    private String clothes;
    private String type;
    private String color;
    private String sleeve;
    private String material;

    public Spot(String clothes, String type, String color, String sleeve, String material) {
        this(0, clothes, type, color ,sleeve, material);
    }

    public Spot(int id, String clothes, String type,String color , String sleeve, String material) {
        this.id = id;
        this.clothes = clothes;
        this.type = type ;
        this.color = color ;
        this.sleeve = sleeve;
        this.material = material;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getClothes() {
        return clothes;
    }

    public void setColor(String color) {this.color = color;}

    public String getColor() {
        return color;
    }

    public void setType(String type) {this.type = type;}

    public String getType() {
        return type;
    }

    public void setSleeve(String sleeve) {this.sleeve = sleeve;}

    public String getSleeve() {return sleeve;}

    public void setMaterial(String material) {this.material = material;}

    public String getMaterial() {return material;}

}
