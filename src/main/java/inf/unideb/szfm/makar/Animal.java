package inf.unideb.szfm.makar;

import javax.persistence.*;

@Entity
public class Animal {
    private String name;

    @Basic(optional = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int Age;

    @Basic
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    private GenderEnum Gender;

    @Basic
    @Enumerated(EnumType.STRING)

    public GenderEnum getGender() {
        return Gender;
    }

    public void setGender(GenderEnum gender) {
        Gender = gender;
    }

    private Integer id;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
