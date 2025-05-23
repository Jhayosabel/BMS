
package config;

public class Session {
    
    private static Session intance;

    public static Session getInstance() {
        return null;
    }
    private int uid;
    private String uname; 
    private String email; 
    private String uuser; 
    private String password;
    private String ustatus; 
    private String type;
    
    private Session(){
        //Private cons. private instance
    }

    public static synchronized Session getIntance() {
        if(intance == null){
            intance = new Session();
        }
        return intance;
    }

    public static boolean isIntanceEmpty(){
        return intance == null;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String utatus) {
        this.ustatus = utatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    
}
