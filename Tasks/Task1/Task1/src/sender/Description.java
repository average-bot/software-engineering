package sender;

import java.io.Serializable;

public class Description implements Serializable {
    private String title;
    private String text;

    Description(String text, String title){
        this.text = text;
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
