package Project.src;

public class UserVo {
    private String  id;
    private String  pw;

    public UserVo(String id, String password) {
        this.id = id;
        this.pw = password;
    }

    public UserVo() {

    }

    public UserVo(String id, char[] pw) {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.pw;
    }

    public void setPassword(String password) {
        this.pw = password;
    }



}
