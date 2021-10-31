package kim.nikita.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class JsonClassWithNameAndId {

    public String name;

    public Integer id;

    public JsonClassWithNameAndId()
    {

    }

}
