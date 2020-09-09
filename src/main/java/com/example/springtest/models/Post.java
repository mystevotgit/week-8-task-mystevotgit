package com.example.springtest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="posts")
public class Post {
    @Id
    private long id;
    private long user_id;
    private String post_date;
    private String post_text;

    public void setPost_date() {
        Date date = new Date();
        String res = "";
        String str = String.valueOf(date);
        List<String> list = Arrays.asList(str.split(" "));
        res += list.get(list.size()-1);
        res += "-";
        String month;
        String val = list.get(1);
        switch (val) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + val);
        }
        res += month;
        res += "-";
        res += list.get(2);
        System.out.println(res);
        this.post_date = res;
    }
}
