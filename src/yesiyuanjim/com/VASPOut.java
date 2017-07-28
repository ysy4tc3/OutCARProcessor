package yesiyuanjim.com;

/**
 * Created by meticulous on 2017/7/28.
 */
public class VASPOut {
    private String type = null;
    private String data = null;

    public VASPOut(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

}
