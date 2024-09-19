package phone;

public class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String accountNumber;
    private int cityTalkTime;
    private int longDistanceTalkTime;

    // конструктор
    public Phone(int id, String lastName, String firstName, String middleName, String accountNumber, int cityTalkTime, int longDistanceTalkTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.accountNumber = accountNumber;
        this.cityTalkTime = cityTalkTime;
        this.longDistanceTalkTime = longDistanceTalkTime;
    }

    // геттери/сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCityTalkTime() {
        return cityTalkTime;
    }

    public void setCityTalkTime(int cityTalkTime) {
        this.cityTalkTime = cityTalkTime;
    }

    public int getLongDistanceTalkTime() {
        return longDistanceTalkTime;
    }

    public void setLongDistanceTalkTime(int longDistanceTalkTime) {
        this.longDistanceTalkTime = longDistanceTalkTime;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Прізвище: " + lastName + ", Імʼя: " + firstName + ", По батькові: " + middleName +
                ", Номер рахунку: " + accountNumber + ", Час міських розмов: " + cityTalkTime +
                ", Час міжміських розмов: " + longDistanceTalkTime;
    }
}