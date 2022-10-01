package Netology.part2.Stream;

public class Person {
    protected String name;
    protected String surname;
    protected Integer age;
    protected Sex sex;
    protected Education education;


    public Person(String name,String surname,int age,Sex sex,Education education){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='"+name+'\''+
                ",surname='"+surname+'\''+
                ",age="+age+
                ",sex="+sex+
                ",education="+education+'}';
    }
}
