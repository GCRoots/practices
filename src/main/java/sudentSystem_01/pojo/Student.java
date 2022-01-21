package sudentSystem_01.pojo;

public class Student {

    private String sid;
    private String name;
    private String age;
    private String addrerss;

    public Student() {
    }

    public Student(String sid, String name, String age, String addrerss) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.addrerss = addrerss;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddrerss() {
        return addrerss;
    }

    public void setAddrerss(String addrerss) {
        this.addrerss = addrerss;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", addrerss='" + addrerss + '\'' +
                '}';
    }
}
