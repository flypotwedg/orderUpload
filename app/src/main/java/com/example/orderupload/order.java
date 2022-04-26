package com.example.orderupload;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class order{
    float price;
    String date;
    String time;
    String address;
    String vendorName;
    String vendUID;
    String user;
    String userUID;
    int status; //0 in progress, 1 finished, -1 cancelled

    public order()
    {
        this.price=0;
        this.date=null;
        this.time=null;
        this.address=null;
        this.vendorName=null;
        this.vendUID=null;
        this.user=null;
        this.userUID=null;
        this.status=0;
    }

    public void setPrice(float servPrice)
    {
        price=servPrice;
    }
    public void setAppt(String apptDate, String apptTime)
    {
        date=apptDate;
        time=apptTime;
    }
    public void setAddress(String addr)
    {
        address=addr;
    }
    public void setVendorName(String vendName)
    {
        vendorName=vendName;
    }
    public void setVendUID(String vendorUID)
    {
        vendUID=vendorUID;
    }
    public void setUser(String userName)
    {
        user=userName;
    }
    public void setUserUID(String useUID)
    {
        userUID=useUID;
    }
    public void setStatus(int stat)
    {
        status=stat;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object>result=new HashMap<>();
        result.put("price",price);
        result.put("apptDate",date);
        result.put("apptTime",time);
        result.put("apptAddr",address);
        result.put("vendName",vendorName);
        result.put("vendUID",vendUID);
        result.put("user",user);
        result.put("userUID",userUID);
        result.put("completed",status);

        return result;
    }
}