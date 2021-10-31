package kim.nikita.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class JsonClass {

    public String name;

    public Integer id;

    public Boolean friends;

    public JsonClass()
    {

    }

}
