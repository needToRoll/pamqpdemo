package cloud.buergi.playground.pactamqpdemo.eventconsumer.model;

public class PersonDto {
    public int age;
    public String gender;

    @Override
    public String toString() {
        return "PersonDto{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
