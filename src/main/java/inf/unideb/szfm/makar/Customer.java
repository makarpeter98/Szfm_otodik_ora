package inf.unideb.szfm.makar;

import javax.persistence.*;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String Name;

    @Enumerated(EnumType.STRING)
    private  GenderEnum Gender;
    private Integer Age;

    public GenderEnum getGender() {
        return Gender;
    }

    public void setGender(GenderEnum gender) {
        Gender = gender;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(final String name) {
        this.Name = name;
    }


}
