package like.sirvan.bira.Model;

public class FunctionModel {
    String name;
    String phone;
    String pass;
    String titleOne;
    String codeOne;
    String titleTwo;
    String codeTwo;
    String titleThree;
    String codeThree;


    public FunctionModel(String name, String phone, String pass, String titleOne, String codeOne, String titleTwo, String codeTwo, String titleThree, String codeThree) {
        this.name = name;
        this.phone = phone;
        this.pass = pass;
        this.titleOne = titleOne;
        this.codeOne = codeOne;
        this.titleTwo = titleTwo;
        this.codeTwo = codeTwo;
        this.titleThree = titleThree;
        this.codeThree = codeThree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTitleOne() {
        return titleOne;
    }

    public void setTitleOne(String titleOne) {
        this.titleOne = titleOne;
    }

    public String getCodeOne() {
        return codeOne;
    }

    public void setCodeOne(String codeOne) {
        this.codeOne = codeOne;
    }

    public String getTitleTwo() {
        return titleTwo;
    }

    public void setTitleTwo(String titleTwo) {
        this.titleTwo = titleTwo;
    }

    public String getCodeTwo() {
        return codeTwo;
    }

    public void setCodeTwo(String codeTwo) {
        this.codeTwo = codeTwo;
    }

    public String getTitleThree() {
        return titleThree;
    }

    public void setTitleThree(String titleThree) {
        this.titleThree = titleThree;
    }

    public String getCodeThree() {
        return codeThree;
    }

    public void setCodeThree(String codeThree) {
        this.codeThree = codeThree;
    }
}
