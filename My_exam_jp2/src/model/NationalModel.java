package model;

public class NationalModel {
    int nationalId;
    String nationalName;

    public NationalModel() {}

    public NationalModel(String nationalName) {
        this.nationalName = nationalName;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
