package com.example.wulin.schoolmate;
import org.litepal.crud.DataSupport;

/**
 * Created by 47160 on 2017/9/19.
 */

public class Account extends DataSupport {
    private int id;
    private String password;
    //    private double price;
//    private int pages;
    private String account;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String s){
        password=s;
    }
    //    public double getPrice(){
//        return price;
//    }
//    public void setPrice(double d){
//        price=d;
//    }
//    public int getPages(){
//        return pages;
//    }
//    public void setPages(int i){
//        pages=i;
//    }
    public String getAccount(){
        return account;
    }
    public void setAccount(String s){
        account=s;
    }
}
