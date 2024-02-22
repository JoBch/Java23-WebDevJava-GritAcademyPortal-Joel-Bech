package models;

import java.io.Serializable;
import java.util.List;

public class JavaBean implements Serializable {

    private String id;
    private USER_TYPE userType;
    private PRIVILEGE_TYPE privilegeType = PRIVILEGE_TYPE.user;
    private STATE_TYPE stateType = STATE_TYPE.anonymous;
    private List<String[]> data = null;


    public JavaBean(String id, USER_TYPE userType, PRIVILEGE_TYPE privilegeType, STATE_TYPE stateType) {
        this.id = id;
        this.userType = userType;
        this.privilegeType = privilegeType;
        this.stateType = stateType;
    }

    public JavaBean() {
    }

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setprivilegeType(PRIVILEGE_TYPE privilegeType) {
        this.privilegeType = privilegeType;
    }

    public PRIVILEGE_TYPE getprivilegeType() {
        return privilegeType;
    }

    public STATE_TYPE getStateType() {
        return stateType;
    }

    public void setStateType(STATE_TYPE stateType) {
        this.stateType = stateType;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

}