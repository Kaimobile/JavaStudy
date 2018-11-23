//The codes of download function is from "https://www.dstang.com"

package week8;

import java.net.URL;
import java.util.Date;
import java.io.*;
 
class Downloader 
{
    public static void main(String[] args)
        throws Exception
    {
        final URL[] urls = {
            new URL("https://www.pku.edu.cn"),
            new URL("https://www.baidu.com"),
            new URL("https://www.sina.com.cn"),
            new URL("https://www.dstang.com")
        };
        final String[] files = {
            "pku.htm", 
            "baidu.htm",
            "sina.htm", 
            "study.htm",
        };
        long a = new Date().getTime();
        long b = 1;
        Thread down1 = new DownloadThread(urls[0],files[0]);
        Thread down2 = new DownloadThread(urls[1],files[1]);
        Thread down3 = new DownloadThread(urls[2],files[2]);
        Thread down4 = new DownloadThread(urls[3],files[3]);
        down1.start();
        down2.start();
        down3.start();
        down4.start();
        while(down1.isAlive() || down2.isAlive() || down3.isAlive() || down4.isAlive()) {
        	b = new Date().getTime();
        }
        System.out.println(b-a);
    }
    
}
class DownloadThread extends Thread
{
	URL url ;
	String files ;
	public DownloadThread(URL url, String files) {
		super();
		this.url = url;
		this.files = files;
	}
	@Override
	public void run() {
		try{
            System.out.println( url);
            this.download( url, files);
        }catch(Exception ex){
            ex.printStackTrace();
        }
	}
	static void download( URL url, String file)
	        throws IOException
	    {
	        try(InputStream input = url.openStream();
	            OutputStream output = new FileOutputStream(file))
	        {
	            byte[] data = new byte[1024];
	            int length;
	            while((length=input.read(data))!=-1){
	                output.write(data,0,length);
	            }
	        }
	    }
}
