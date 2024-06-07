/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author USER
 */
public class OnlineCourse extends Course{
    private String url;

    public OnlineCourse() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }  

    @Override
    public String toString() {
        return super.toString() +"<br>Url: " + url + "</html>";
    }
    
    
}
