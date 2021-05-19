package com.util;

import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class MyProgressListener implements ProgressListener {
    private HttpSession session;
    public MyProgressListener(HttpServletRequest request){
        session = request.getSession();
    }
    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        
        double readM=pBytesRead/1024.0/1024.0;
        
        double totalM=pContentLength/1024.0/1024.0;
        
        double percent=readM/totalM;
        
        
        String readf=dataFormat(pBytesRead);
        
        String totalf=dataFormat(pContentLength);
        
        NumberFormat format=NumberFormat.getPercentInstance();
        String progress=format.format(percent);
        
       
        session.setAttribute("progress", progress);
        
        
        System.out.println("pBytesRead===>"+pBytesRead);
        System.out.println("pContentLength==>"+pContentLength);
        System.out.println("pItems===>"+pItems);
        System.out.println("readf--->"+readf);
        System.out.println("totalf--->"+totalf);
        System.out.println("progress--->"+progress);
    }
    /**
     * 
     * @param data byte
     * @return  1M 1M
     */
    public String dataFormat(double data){
        String formdata="";
        if (data>=1024*1024) {//1M
            formdata=Double.toString(data/1024/1024)+"M";
        }else if(data>=1024){//1KB
            formdata=Double.toString(data/1024)+"KB";
        }else{//1KB
            formdata=Double.toString(data)+"byte";
        }
        return formdata.substring(0, formdata.indexOf(".")+2);
    }

}