package entity;

public class Candidate {
    private String cadidateId;
    private String fName;
    private String lName;
    private int dateBirth;
    private String address;
    private String phone;
    private String email;
    private int cadidateType;

    public Candidate() {
    }

    public String getCadidateId() {
        return cadidateId;
    }

    public void setCadidateId(String cadidateId) {
        this.cadidateId = cadidateId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(int dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCadidateType() {
        return cadidateType;
    }

    public void setCadidateType(int cadidateType) {
        this.cadidateType = cadidateType;
    }

    @Override
    public String toString() {
        return fName + " " + lName + "|" + dateBirth + "|" + address + "|" + phone + "|" + email + "|" + cadidateType;
    }
}
